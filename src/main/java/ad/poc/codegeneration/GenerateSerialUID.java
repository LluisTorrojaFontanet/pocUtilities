/**
 * @author Lluís Torroja Fontanet - C127USU
 */

package ad.poc.codegeneration;

import java.io.File;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.ToString2;

public class GenerateSerialUID {

	public static void main(String[] args) {
		Iterator it = FileUtils.iterateFiles(new File("./src/main/java/ad/cass"), new String[] {"java"}, true);
        while(it.hasNext()) {
        	File fileName = ((File) it.next());
        	String className = fileName.getPath().replace("./src/main/java/", "").replace("/", ".").replace(".java", "");
            Class cl;
 			try {
				cl = Class.forName(className).newInstance().getClass();
		   	    long uid = ObjectStreamClass.lookup(cl).getSerialVersionUID();
		   	    String strFileNameOutput = FileUtils.readFileToString(fileName);
		   	    strFileNameOutput = strFileNameOutput.replace(
		   	    			"implements Serializable, Equals2, HashCode2, ToString2\n" + 
		   	    			"{", 
		   	    			"implements Serializable, Equals2, HashCode2, ToString2\n" + 
		   	    			"{\n\tprivate static final long serialVersionUID = " + uid + "L;");
		   	    FileUtils.writeStringToFile(fileName, strFileNameOutput);
				System.out.println("OK: " + className + " ---> private static final long serialVersionUID = " + uid);
				
			} catch (Exception e) {
				System.out.println("ERROR: " + className + " sense SerialUID");
			} 
        }
//	    Class cl = obj.getClass();
//	    long uid = ObjectStreamClass.lookup(cl).getSerialVersionUID();
//	    System.out.println("uid:" + uid);
	}

}


