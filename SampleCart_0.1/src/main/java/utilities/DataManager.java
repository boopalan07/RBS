package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DataManager {

	static Properties prop=new Properties();
	
	public static String getConfigData(String key) throws Exception{
		String value="";
		try{
			File file=new File("src/main/resources/config.properties");
			InputStream input=new FileInputStream(file);
			prop.load(input);
			value=prop.getProperty(key);
		}catch (Exception e) {
			throw new Exception("Can not find a value from property file "+key+"\n"+e.getMessage());
		}
		return value;
	}
}
