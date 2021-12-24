package com.BaseLayer;

import java.io.FileInputStream;
import java.util.Properties;

public class abc {

	public static Properties prop;

	public static FileInputStream fis;

	public abc() {
		prop = new Properties();

		try {
			fis = new FileInputStream(
					"/Users/prafulpawar/Nov Script /RestAssuredNovBatch/src/main/java/com/Config/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(prop.getProperty("FirstName"));
	}

}
