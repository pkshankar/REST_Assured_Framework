package com.qa.gorest.util;

import java.util.HashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

	public static String pojoToJson(Object obj) {

		String jsonString = null;

		ObjectMapper mapper = new ObjectMapper();

		try {

			jsonString = mapper.writeValueAsString(obj);
			return jsonString;

		} catch (JsonProcessingException e) {

			e.printStackTrace();
			return jsonString;
		}
	}

	public static HashMap<String, String> addToMap(String mapKey, String mapValue) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put(mapKey, mapValue);
		return map;
	}
}
