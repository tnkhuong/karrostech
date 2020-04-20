package stepDefinations;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class StepDefination extends Utils{
	RequestSpecification res;
	String response;
	JsonPath js;
	@Given("GetPost API with id is {string}")
	public void getpost_API_with_id_is(String id) throws IOException {
		res=given().spec(requestSpecification()).pathParam("id",id );
	}

	@When("user calls GetPost API with GET http request")
	public void user_calls_GetPost_API_with_http_request() {
		response=res.when().get("/typicode/demo/posts/{id}")
				.then().log().all().extract().response().asString();
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String id, String title) {
		js=new JsonPath(response);
		Assert.assertEquals(js.get("id").toString(),"1");
		Assert.assertEquals(js.get("title"), "Post 1");
	}

}
