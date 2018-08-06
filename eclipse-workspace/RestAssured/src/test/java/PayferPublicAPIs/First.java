package PayferPublicAPIs;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class First {
	
	@Test
	public void generateToken(){
		
		RestAssured.baseURI= "https://maps.googleapis.com";
		
		given().
				param("location", "-33.8670522,151.1957362").
				param("radius", "500").
				param("key", "AIzaSyCLNfIEHSWfqWNkNd64zvptrKT9oKOEP98").log().all().
				when().
				get("maps/api/place/nearbysearch/json").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
				 body("results[0].name",equalTo("Sydney")).and().
			       body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
			       header("Server","scaffolding on HTTPServer2");
				
;				//asString();
		
		
		//System.out.println("Response is : "  + );
		
	}

	

}
