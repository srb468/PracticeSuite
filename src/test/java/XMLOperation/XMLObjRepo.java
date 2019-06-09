package XMLOperation;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XMLObjRepo {

	@Test
	public void a1() throws DocumentException {

	
		File inputFile = new File(System.getProperty("user.dir") + "\\XMLRepository.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		String all = document.getName();
		String url = document.selectSingleNode("//menu/url").getText();
		System.out.println(url); 
		
	}
}
