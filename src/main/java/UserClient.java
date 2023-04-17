import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient{

    public final String USER_URL = BASE_URI +"/auth/user";
    public final String LOGIN_URL = BASE_URI + "/auth/login";


    public String accessToken;
    UserCreds userCreds;

    @Step("Login {user}")
    public ValidatableResponse login(UserCreds userCreds) {

        return given()
                .spec(getBaseReqSpec())
                .log().all()
                .body(userCreds)
                .when()
                .post(LOGIN_URL)
                .then().log().all();
    }


    @Step("Login {user}")
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getBaseReqSpec())
                .header("Authorization",accessToken)
                .log().all()
                .when()
                .delete(USER_URL)
                .then().log().all();
    }
}
