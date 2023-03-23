package oi1.panel.restassured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MiSegundoTest {

	private String BASE_URI;
	
	@BeforeSuite
	public void setup() {
		BASE_URI = "https://pokeapi.co";
	}
	
	@DataProvider(name = "dataProvider")
	public Object[][] getPokemonIds() {
		return new Object[][]{{3}, {6}, {7}};
	}
	
	@Test(dataProvider = "dataProvider")
	public void test(int pokemonID) {
		Response response = given()
			.baseUri(BASE_URI)
		.when()
			.get("/api/v2/pokemon/" + pokemonID)
		.then()
			.assertThat().statusCode(200)
			.extract().response();
	
		JsonPath jsonpath = response.jsonPath();
		Object moves = jsonpath.getList("moves");
		System.out.println(moves);
	}
	
}
