package XMLOperation;

import org.testng.annotations.Test;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadAllXML {

	@Test
	public void c() throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		Document document = builder.parse(new File("XMLRepository.xml"));

		// Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();

		// Here comes the root node
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());

		// Get all employees
		NodeList nList = document.getElementsByTagName("netFLowClientList");
		System.out.println("============================");

		System.out.println("size" + nList.getLength());
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			System.out.println(""); // Just a separator
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// Print each employee's detail
				Element eElement = (Element) node;
				System.out.println("Employee id" + (temp + 1) + " : " + eElement.getAttribute("id"));
				System.out.println("out file location : "
						+ eElement.getElementsByTagName("outFileLocation").item(0).getTextContent());
				// System.out.println("Last Name : " +
				// eElement.getElementsByTagName("lastName").item(0).getTextContent());
				// System.out.println("Location : " +
				// eElement.getElementsByTagName("location").item(0).getTextContent());

			}
		}
	}
}
