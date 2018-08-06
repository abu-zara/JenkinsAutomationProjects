package PayferPublicAPIs;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payLoad;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class RegAccntOnPayfer {
	
	 public static Response response;
	 public static String jsonAsString;
	 //Properties prop = new Properties();
	 
	 
	 @BeforeTest
	 public void setUlr() throws IOException {
		 
		 FileInputStream fis = new FileInputStream("C:\\Users\\Ismail\\eclipse-workspace\\RestAssured\\src\\test\\java\\files\\env.properties");
		 prop.load(fis);
		 
	 }
	 
	 
	@Test
	public void register(){
		
		
		
		 RestAssured.baseURI = prop.getProperty("HOST");
		 Response res = given().
				headers("Content-Type", "application/json").
				body(payLoad.getPostData()).
				when().
				post(resources.placePostData()).
				then().
				assertThat().contentType(ContentType.JSON).and().
				extract().response();
		 		
		 	     String stringresponse = res.asString();
		 	     System.out.println(stringresponse);
		 	     JsonPath js = new JsonPath(stringresponse);
		 	     String messge = js.get("message");
		 	     String status = js.get("status");
		 	     String data = js.get("data.Email");
		 	     System.out.println(messge);
		 	     System.out.println(status);
		 	     System.out.println(data);
		 	     
		 	    
			
	}
	

}
