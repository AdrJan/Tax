package automation_practice;

import api.dictionary.ApiRequestsParams;
import api.pojo.CreatedUserDataPojo;
import api.pojo.UserListPojo;
import api.pojo.UserPojo;
import api.request.RegresInApiRequest;
import core.lib.test_setup.TestListener;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Listeners(TestListener.class)
public class ApiTests {

    RegresInApiRequest regresInApiRequest = new RegresInApiRequest();

    //** API TESTING PLAYGROUND **

    @Test
    public void checkUser() {
        checkUser(1, "George");
        checkUser(2, "Janet");
        checkUser(3, "Emma");
    }

    @Test
    public void checkUserListSize() {
        UserListPojo userListPojo = regresInApiRequest
                .getListUsers("page", 2)
                .as(UserListPojo.class);

        Assert.assertEquals(userListPojo.getData().size(), userListPojo.getPer_page());
    }

    @Test
    public void checkUnknownService404() {
        checkUnknown(23, 404);
    }

    @Test
    public void checkUnknownService200() {
        checkUnknown(2, 200);
    }

    @Test
    public void checkNewUser() {
        checkNewUser("Roman", "Taxi driver");
    }

    // *** METHODS ***

    public void checkNewUser(String name, String job) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);
        requestParams.put("job", job);

        given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .body(requestParams)
                .when()
                .post(ApiRequestsParams.REGRES_IN_API_USER_SERVICE)
                .as(CreatedUserDataPojo.class);
    }

    private void checkUnknown(int id, int expectedStatusCode) {
        given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .when()
                .get(ApiRequestsParams.REGRES_IN_API_UNKNOWN_SERVICE + id)
                .then()
                .statusCode(expectedStatusCode);
    }

    private void checkUser(int userId, String expectedName) {
        UserPojo user = given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .get(ApiRequestsParams.REGRES_IN_API_USER_SERVICE + userId)
                .as(UserPojo.class);

        Assert.assertEquals(user.getData().getFirst_name(), expectedName);
    }
}
