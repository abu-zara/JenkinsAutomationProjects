package PayferPublicAPIs;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class PayF {
	
	 public static Response response;
	 public static String jsonAsString;
	 
	 @BeforeClass
	 public void setUlr(){
		 
		 RestAssured.baseURI= "https://jnfx.test.vggdev.com";
	 }
	 
	 
	@Test
	public void getCountriesId(){
		
		
		
		 response = given().
				when().
				get("/api/client/countries").
				then().assertThat().contentType(ContentType.JSON).and().
				header("Server", "Microsoft-IIS/8.5").
				extract().response();
		 		jsonAsString = response.asString();
		 		
		 		System.out.println(jsonAsString);
			
	}
	
				 


	

}
