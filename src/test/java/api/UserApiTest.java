package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserApiTest {

    // ✅ GET PRODUCTS (Amazon jaisa)
    @Test
    public void getProducts() {

        RestAssured.baseURI = "https://fakestoreapi.com";

        given()
                .when()
                .get("/products")
                .then()
                .log().all()
                .statusCode(200);
    }

    // ❌ DELETE PRODUCT
    @Test
    public void deleteProduct() {

        RestAssured.baseURI = "https://fakestoreapi.com";

        given()
                .when()
                .delete("/products/1")
                .then()
                .log().all()
                .statusCode(200);
    }
}