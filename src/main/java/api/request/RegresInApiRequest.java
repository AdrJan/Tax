package api.request;

import api.dictionary.ApiRequestsParams;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class RegresInApiRequest {

    public Response getListUsers(String param, Object value) {
        return given()
                .baseUri(ApiRequestsParams.REGRES_IN_API_BASE_URI)
                .basePath(ApiRequestsParams.REGRES_IN_API_BASE_PATH)
                .queryParam(param, value)
                .when()
                .get(ApiRequestsParams.REGRES_IN_API_LIST_USERS_SERVICE);
    }
}
