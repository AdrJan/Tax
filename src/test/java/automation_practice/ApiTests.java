package automation_practice;

import api.pojo.CreatedUserDataPojo;
import api.pojo.UserListPojo;
import api.pojo.UserPojo;
import api.request.RegresInApiRequest;
import core.lib.test_setup.TestListener;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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

        CreatedUserDataPojo createdUserDataPojo = regresInApiRequest
                .postNewUser(requestParams)
                .as(CreatedUserDataPojo.class);

        Assert.assertEquals(name, createdUserDataPojo.getName());
    }

    private void checkUnknown(int id, int expectedStatusCode) {
        regresInApiRequest
                .getUnknownService(id)
                .then()
                .statusCode(expectedStatusCode);
    }

    private void checkUser(int userId, String expectedName) {
        UserPojo user = regresInApiRequest
                .getUser(userId)
                .as(UserPojo.class);

        Assert.assertEquals(user.getData().getFirst_name(), expectedName);
    }
}
