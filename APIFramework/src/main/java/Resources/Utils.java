package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import com.sun.net.httpserver.Filter;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {


	public String getGlobalProp(String propName) throws IOException {
		FileInputStream fis = new FileInputStream("configuration.txt");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(propName);
	}
	
	public RequestSpecification getReqSpec() throws IOException {
		double i = Math.random()*100;
		PrintStream log = new PrintStream(new FileOutputStream(i+"log.txt"));
		RequestSpecBuilder rqsb = new RequestSpecBuilder()
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setBaseUri(getGlobalProp("baseurl"))
				.addQueryParam("key","qaclick123")
				.setContentType(ContentType.JSON);
		return rqsb.build();	

	}	
	public ResponseSpecification getResSpec() {

		ResponseSpecBuilder rspb = new ResponseSpecBuilder().expectContentType(ContentType.JSON);
		return rspb.build();
	}

	
}
