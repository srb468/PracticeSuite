package com.practiceSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Retest {
	
	public static void main(String args[]) throws JsonProcessingException, IOException {
		

		//read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get("C:\\Workspace\\com.practiceSuite\\File.json"));

		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read JSON like DOM Parser
		JsonNode rootNode = objectMapper.readTree(jsonData);
		JsonNode idNode = rootNode.path("id");
		String id = idNode.toString();
		
		
		System.out.println("id = "+idNode.asInt());

		JsonNode phoneNosNode = rootNode.path("phoneNumbers");
		Iterator<JsonNode> elements = phoneNosNode.elements();
		while(elements.hasNext()){
			JsonNode phone = elements.next();
			System.out.println("Phone No = "+phone.asLong());
		}
		JsonNode prop = rootNode.path("address");
		String a = prop.get("street").toString();
		System.out.println(a);
	}

}
