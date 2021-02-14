package api.request;

import api.dictionary.ApiRequestsParams;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;


public class RegresInApiRequest {

    // *** GET ***

    public Response getListUsers(String param, Object value) {
        return given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .queryParam(param, value)
                .when()
                .get(ApiRequestsParams.REGRES_IN_API_LIST_USERS_SERVICE);
    }

    public Response getUnknownService(int id) {
        return given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .when()
                .get(ApiRequestsParams.REGRES_IN_API_UNKNOWN_SERVICE + id);
    }

    public Response getUser(int userId) {
        return given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .get(ApiRequestsParams.REGRES_IN_API_USER_SERVICE + userId);
    }

    // *** POST ***

    public Response postNewUser(JSONObject requestParams) {
        return given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .body(requestParams)
                .when()
                .post(ApiRequestsParams.REGRES_IN_API_USER_SERVICE);
    }
}
