package com.amazon.util;

import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonHandler {

	public JSONObject readJSON() throws Exception {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./resources/testData.json"));
		JSONObject jsonObject = (JSONObject) obj;
	/*	File file = new File("./resources/testData.json");
		String content = FileUtils.readFileToString(file, "utf-8");

		// Convert JSON string to JSONObject
		JSONObject tomJsonObject = new JSONObject(content);*/
		return jsonObject;
	}
}
