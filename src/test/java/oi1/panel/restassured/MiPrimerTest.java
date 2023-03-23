package oi1.panel.restassured;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MiPrimerTest {

	private String BASE_URI;
	
	@BeforeSuite
	public void setup() {
		BASE_URI = "https://pokeapi.co";
	}
	
	@Test
	public void firstTest() {
		given()
			.baseUri(BASE_URI)
		.when()
			.get("/api/v2/pokemon/3")
		.then()
			.log().all()
			.assertThat().statusCode(200);
	}
	
	
	@Test
	public void secondTest() {
		Response response = given()
			.baseUri(BASE_URI)
		.when()
			.get("/api/v2/pokemon/3")
		.then()
			.assertThat().statusCode(200)
			.extract().response();
		
		JsonPath jsonpath = response.jsonPath();
		Object moves = jsonpath.getList("moves");
		System.out.println(moves);
		System.out.println(((List<Object>)moves).get(0));
	}
	
}
