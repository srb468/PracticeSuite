package com.practiceSuite;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParser {

	public static void main(String[] args) {

		JSONObject jObj = new JSONObject();
		JSONObject add = new JSONObject();

		add.put("streetAddress", "21 2nd Street");
		add.put("city", "New York");
		add.put("state", "NY");
		add.put("postalCode", "888005");

		JSONObject j1 = new JSONObject();
		j1.put("type", "home");
		j1.put("number", "4234234");

		JSONObject j2 = new JSONObject();
		j2.put("type", "fax");
		j2.put("number", "545325423");

		JSONArray jArr = new JSONArray();
		jArr.add(j1);
		jArr.add(j2);

		jObj.put("firstName", "John");
		jObj.put("lastNmae", "Smith");
		jObj.put("age", "22");
		jObj.put("address", add);
		jObj.put("phoneNumbers", jArr);

		System.out.println(jObj.toString());
		String payLoad = jObj.toString();

		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(payLoad);
		
		if (jsonTree.isJsonObject()) {
			JsonObject jsonObject = jsonTree.getAsJsonObject();
			JsonElement f1 = jsonObject.get("firstName");

		    JsonElement f2 = jsonObject.get("address");
		    
		    System.out.println(f2);
		}
		
	}
}
