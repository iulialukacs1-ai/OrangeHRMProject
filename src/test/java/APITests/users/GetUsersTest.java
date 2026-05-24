package APITests.users;

import APIBaseTest.BaseAPI;
import config.TestConfig;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

@Epic("ReqRes API Testing")
@Feature("User Management")
@Story("GET Users List")

public class GetUsersTest extends BaseAPI {
    //=============== Test 1 =============//
    //1. Setez header-ul x-api-key cu cheia.
    //2. Trimiț un request GET către /api/users?page=2.
    //3. Verific ca raspunsul este 200.
    //4. Verific ca lista de utilizatori exista.
    //5. Verific ca pagina returnata este 2.

    @Test
    @Description("Verifica faptul ca endpoint-ul GET /users?page=2 returneaza lista de utilizatori")
    @Severity(SeverityLevel.NORMAL)
    public void getUsersList() {
        given()
                .header("x-api-key", TestConfig.API_KEY)
                .queryParam("page", 2)
                .when()
                .get(TestConfig.BASE_URL + TestConfig.USERS_ENDPOINT)
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", not(empty()))
                .body("data[0].id", notNullValue());
    }
}
