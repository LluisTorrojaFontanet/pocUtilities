package ad.cass.poc.scan;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import au.com.southsky.jfreesane.SaneDevice;
import au.com.southsky.jfreesane.SaneSession;

@RunWith(JUnit4.class)
public class ExerciserCASScaner {

	private SaneSession session;
	private SaneDevice device;
	private BufferedImage image;
	private File file;
	
	@Test
	public void scanejar() {
		
		try {
			System.out.println("Inici");

			InetAddress address = InetAddress.getByName("scanner02");
			session = SaneSession.withRemoteSane(address,6566);
			List<SaneDevice> devices = session.listDevices();
			device = session.getDevice(devices.get(0).getName());
			//device.close();
			session.close();

			System.out.println("Scanning 01 ...");
			acquireImage();
			System.out.println("Scanned 01");

			System.out.println("Scanning 02 ...");
			acquireImage();
			System.out.println("Scanned 02");

			System.out.println("Fi");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	private void acquireImage() throws Exception {

		InetAddress address = InetAddress.getByName("scanner02");
		
		boolean connected = false;
		while (!connected) {
			try {
				session = SaneSession.withRemoteSane(address,6566);
				connected=true;
				System.out.println("OK escanner02 ...");
			} catch (Exception e) {
				System.out.println("esperant escanner02 ...");
				TimeUnit.SECONDS.sleep(1);
			}
		}
			
		List<SaneDevice> devices = session.listDevices();
		device = session.getDevice(devices.get(0).getName());

		if (!device.isOpen())
			device.open();
		
		image = device.acquireImage();
		file = File.createTempFile("mono-image-flat", ".png", new File("src/test/resources"));
		ImageIO.write(image, "png", file);
		
		device.close();
		
		session.close();
		
	}
	
}
