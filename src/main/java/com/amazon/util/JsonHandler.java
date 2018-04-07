package com.amazon.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class JsonHandler {

	public JSONObject readJSON() throws Exception {
		File file = new File("./resources/testData.json");
		String content = FileUtils.readFileToString(file, "utf-8");

		// Convert JSON string to JSONObject
		JSONObject tomJsonObject = new JSONObject(content);
		return tomJsonObject;
	}
}
