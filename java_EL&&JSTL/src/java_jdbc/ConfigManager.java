package java_jdbc;
//读取配置文件的工具类-单利模式

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
 * 这个类设置成单例模式，是指这个类有且只有一个实例，配置文件只需要读取一次，重复读取又会IO操作形成资源浪费
 */
public class ConfigManager {
   //读取配置文件 properties.load(inputstream)
	private static ConfigManager configManager;
	private static Properties properties;
	
	private ConfigManager(){
		String configFile = "data.properties";
		properties = new Properties();
		//ConfigManager.class.getClassLoader() 获取classpath路径
		//getResourceAsStream以流的形式获取配置文件
		//通过classpath获取配置文件，当前类的所在包的根目录下
		InputStream is=ConfigManager.class.getClassLoader()
		.getResourceAsStream(configFile);
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//用static是因为构造方法是私有的不能new对象
	public static ConfigManager getInstance(){
		if(configManager ==null){
			configManager = new ConfigManager();
		}
		return configManager;
	}
	//这里不用static，是因为已经有ConfigManager.getInstance了，已经实例化了，就可以直接用普通方法了
	public String getString(String key){
		return properties.getProperty(key);
	}
	
}
