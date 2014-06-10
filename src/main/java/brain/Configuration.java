package brain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	static {
		loadProperties();
	}
	
	private static Properties properties;
	private static String serverPort;
	private static String webRootPath;
	
	private static void loadProperties() {
		properties = new Properties();
		InputStream is = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			properties.load(is);
			serverPort = properties.getProperty("serverPort", "8080");
			webRootPath = properties.getProperty("webRootPath", "");
		} catch (IOException e) {
			System.err.println("Error while loading property file");
			e.printStackTrace();
		}
	}

	/**
	 * @return the serverPort
	 */
	public static String getServerPort() {
		return serverPort;
	}

	/**
	 * @return the webRootPath
	 */
	public static String getWebRootPath() {
		return webRootPath;
	}

	/**
	 * @param serverPort the serverPort to set
	 */
	public static void setServerPort(String serverPort) {
		Configuration.serverPort = serverPort;
	}

	/**
	 * @param webRootPath the webRootPath to set
	 */
	public static void setWebRootPath(String webRootPath) {
		Configuration.webRootPath = webRootPath;
	}
	
	
}
