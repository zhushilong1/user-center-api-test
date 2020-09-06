package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static hellocucumber.Parameters.BOSE_HOST;
import static org.junit.Assert.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {

    Response response = null;

    @When("^I send a GET request to \"(.*?)\"$")
    public void getRequest(String path) {
        response = ApiTools.get(BOSE_HOST+path);
    }

    @When("^I send a POST request to \"(.*?)\"$")
    public void postRequest(String apiPath) throws Throwable {
        response = ApiTools.post(BOSE_HOST+apiPath);
    }

    @When("^I send a POST request to \"(.*?)\" and request json:$")
    public void postRequestWithJson(String apiPath, String json) {
        response = ApiTools.post(BOSE_HOST+apiPath, json);
    }

//    @When("^I use a \"(.*?)\" file to send a POST request to \"(.*?)\"$")
//    public void postRequestWihtFile(String fileName, String path) {
//        String json = ReadTxtFile.readTxtFile(fileName);
//        response = ApiTools.post(path, json);
//    }

//    @Then("^the JSON response equals$")
//    public void assertResponseJson(String expected) {
//        String responseJson = response.body().asString();
//        assertJsonEquals(responseJson, expected);
//    }

//    @Then("^the JSON response equals json file \"(.*?)\"$")
//    public void theJSONResponseEqualsJsonFile(String fileName) {
//        String responseJson = response.body().asString();
//        String fileJson = ReadTxtFile.readTxtFile(fileName);
//        assertJsonEquals(responseJson, fileJson);
//    }

    @Then("^the response status should be \"(\\d{3})\"$")
    public void assertStatusCode(int statusCode) {
        Object jsonResponse = response.getStatusCode();
//        assertS(jsonResponse, statusCode);
    }

    @Then("^the JSON response \"(.*?)\" equals \"(.*?)\"$")
    public void assertEquals(String str, String expected) {
        String jsonValue = ApiTools.getJsonPathValue(response, str);
//        MyAssert.assertEquals(jsonValue, expected);
    }

    @Then("^the JSON response \"(.*?)\" type should be \"(.*?)\"$")
    public void assertMatch(String str, String match) {
        String jsonValue = ApiTools.getJsonPathValue(response, str);
//        MyAssert.assertMatch(jsonValue, match);
    }

    @Then("^the JSON response \"(.*?)\" should be not null$")
    public void assertNotNull(String str) {
        String jsonValue = ApiTools.getJsonPathValue(response, str);
//        MyAssert.assertNotNull(jsonValue);
    }

    @Then("^the JSON response \"(.*?)\" start with \"(.*?)\"$")
    public void assertStartWith(String str, String start) {
        String jsonValue = ApiTools.getJsonPathValue(response, str);
//        MyAssert.assertStartWith(jsonValue, start);
    }

    @Then("^the JSON response \"(.*?)\" end with \"(.*?)\"$")
    public void assertEndWith(String str, String end) {
        String jsonValue = ApiTools.getJsonPathValue(response, str);
//        MyAssert.assertEndWith(jsonValue, end);
    }

    @Then("^the JSON response \"(.*?)\" include \"(.*?)\"$")
    public void assertInclude(String str, String include) {
        String jsonValue = ApiTools.getJsonPathValue(response, str);
//        MyAssert.assertInclude(jsonValue, include);
    }
}
