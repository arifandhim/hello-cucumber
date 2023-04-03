package hellocucumber.steps;

import hellocucumber.utils.RestAssuredUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class RestAssuredUtilsStepDefinitions {

    private RestAssuredUtils restAssuredUtils;
    private Response response;

    @Given("the base URI is {string}")
    public void the_base_URI_is(String baseURI) {
        restAssuredUtils = new RestAssuredUtils(baseURI);
    }

    @Given("the query parameter {string} is set to {string}")
    public void the_query_parameter_is_set_to(String name, String value) {
        restAssuredUtils.withQueryParam(name, value);
    }

    @Given("the header {string} is set to {string}")
    public void the_header_is_set_to(String name, String value) {
        restAssuredUtils.withHeader(name, value);
    }

    @Given("the request body is:")
    public void the_request_body_is(String body) {
        restAssuredUtils.setRequestBody(body);
    }

    @When("a GET request is sent to {string}")
    public void a_GET_request_is_sent_to(String path) {
        response = restAssuredUtils.get(path);
    }

    @When("a POST request is sent to {string}")
    public void a_POST_request_is_sent_to(String path) {
        response = restAssuredUtils.post(path);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response body should not be empty")
    public void the_response_body_should_not_be_empty() {
        Assert.assertNotNull(response.getBody());
    }

    @Then("the response body should contain the field {string}")
    public void the_response_body_should_contain_the_field(String fieldName) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(fieldName));
    }

}
