/**
 * @author Lluís Torroja Fontanet - C127USU
 */

package ad.cass.poc;

import java.io.File;
import java.io.ObjectStreamClass;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class ExerciserAddAnnotations {

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
		   	    			"@XmlRootElement", 
		   	    			"@JsonSerialize(include=Inclusion.NON_NULL)\n@XmlRootElement");
		   	    strFileNameOutput = strFileNameOutput.replace(
	   	    			"import org.jvnet.jaxb2_commons.lang.Equals2;", 
	   	    			"import org.codehaus.jackson.map.annotate.JsonSerialize;\n"
	   	    			+ "import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;\n"
	   	    			+ "import org.jvnet.jaxb2_commons.lang.Equals2;");		   	    
		   	    FileUtils.writeStringToFile(fileName, strFileNameOutput);
		   	    
		   	    
		   	    
				System.out.println("OK: " + className + " ---> TAG ADDED");
				
			} catch (Exception e) {
				System.out.println("ERROR: " + className);
			} 
        }
//	    Class cl = obj.getClass();
//	    long uid = ObjectStreamClass.lookup(cl).getSerialVersionUID();
//	    System.out.println("uid:" + uid);
	}

}


