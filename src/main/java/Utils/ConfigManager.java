package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager manager;
	private static final Properties prop = new Properties();
	FileInputStream ip;
	
private ConfigManager() {

	try {
	FileInputStream ip;
		ip = new FileInputStream("./src/test/resources/Config.properties");
		prop.load(ip);
		System.out.println("I am here....");
	} catch (FileNotFoundException e) {
		System.out.println("I am here....");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("I am here....");
		e.printStackTrace();
	}
}

public static ConfigManager getInstance() {
	if(manager == null) {
		synchronized(ConfigManager.class) {
			manager = new ConfigManager();
		}
	}
	return manager;
}
public String getString(String key)	{
	return System.getProperty(key, prop.getProperty(key));
}
	

}
