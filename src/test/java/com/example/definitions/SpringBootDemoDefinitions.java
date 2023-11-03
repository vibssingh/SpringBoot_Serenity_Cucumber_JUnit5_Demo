package com.example.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.Assertions;

public class SpringBootDemoDefinitions {
    @Steps
    AbstractRestAssuredHelper helper;
    private Response response;

    @Given("I send a request to the URL {string}")
    public void iSendARequest(String endpoint) throws Exception  {
        response = helper.getAnonymousRequest().contentType("application/json")
                .header("Content-Type", "application/json").when().get(endpoint);
    }

    @Then("the response will return {string}")
    public void extractResponse(String Expected ) {
        SerenityRest.restAssuredThat(response -> response.statusCode(200));
        String Actual = response.asString();
        System.out.println("Result :"+Actual);
        Assertions.assertEquals(Expected, Actual);
    }
}