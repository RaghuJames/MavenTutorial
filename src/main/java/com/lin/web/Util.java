package com.lin.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {

	private static Properties prop;

	public static String getPropertyString(String key) {
		synchronized (prop) {
			if (prop.get(key) == null) {
				return null;
			}
			return prop.get(key).toString();
		}
	}

	public static void loadProperties(String fileName){
		try {
			prop = new Properties();
			synchronized (prop) {
				FileInputStream fIo = null;
				prop = new Properties();
				try {
					fIo = new FileInputStream(fileName);
					prop.load(fIo);
				} catch (IOException io) {
					throw io;
				} finally {
					fIo.close();
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	
}
