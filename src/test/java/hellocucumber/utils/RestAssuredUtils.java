package hellocucumber.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {

    private String baseURI;
    private RequestSpecification requestSpecification;

    public RestAssuredUtils(String baseURI) {
        this.baseURI = baseURI;
        requestSpecification = RestAssured.given().baseUri(baseURI);
    }

    public RestAssuredUtils withQueryParam(String name, String value) {
        requestSpecification.queryParam(name, value);
        return this;
    }

    public RestAssuredUtils withHeader(String name, String value) {
        requestSpecification.header(name, value);
        return this;
    }

    public RestAssuredUtils setRequestBody(String body) {
        requestSpecification.body(body);
        return this;
    }

    public Response get(String path) {
        return requestSpecification.get(path);
    }

    public Response post(String path) {
        return requestSpecification.post(path);
    }

    public Response put(String path) {
        return requestSpecification.put(path);
    }

    public Response delete(String path) {
        return requestSpecification.delete(path);
    }

}

