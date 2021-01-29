package automation_practice;

import api.dictionary.ApiRequestsParams;
import api.pojo.UserPojo;
import core.lib.test_setup.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Listeners(TestListener.class)
public class ApiTests {

    @Test
    public void checkUser() {
        checkUser(1, "George");
        checkUser(2, "Janet");
        checkUser(3, "Emma");
    }

    private void checkUser(int userId, String expectedName) {
        UserPojo user = given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .when()
                .get(ApiRequestsParams.REGRES_IN_API_USER_SERVICE + userId)
                .as(UserPojo.class);

        Assert.assertEquals(user.getData().getFirst_name(), expectedName);
    }
}
