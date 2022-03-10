package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.FrameworkException;

public final class ReadPropertyFile {

	private ReadPropertyFile() {
	}

	private static Properties property = new Properties();
	private static Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try {
			// Load Property file
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(file);

			// Load properties in HashMap
			property.entrySet().forEach(
					e -> CONFIGMAP.put(String.valueOf(e.getKey()).trim(), String.valueOf(e.getValue()).trim()));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase()))) {
			throw new FrameworkException(
					"Property: '" + key + "' does not exist on config.properties file. Please check");
		}
		return CONFIGMAP.get(key.toString().toLowerCase());

	}

}
