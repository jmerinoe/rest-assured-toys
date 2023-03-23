package oi1.panel.restassured;

import static io.restassured.RestAssured.given;

public class Main {

	public static void main(String[] args) {
			given()
			.when()
				.get("https://pokeapi.co/api/v2/pokemon/3")
			.then()
				.statusCode(200);
	}

}
