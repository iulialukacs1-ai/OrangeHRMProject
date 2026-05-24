package APITests.users;

import APIBaseTest.BaseAPI;
import config.TestConfig;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("ReqRes API Testing")
@Feature("User Management")
@Story("GET Single User")

public class GetSingleUserTest extends BaseAPI {

    //==================== Test 2 ======================//
//1. Trimiț GET catre /api/users/2.
//2. Verific status 200.
//3. Verific ca userul exista.
//4. Verific ca ID-ul este 2.

    @Test
    @Description("Verifica faptul ca endpoint-ul GET /users/2 returneaza detaliile utilizatorului cu ID 2")
    @Severity(SeverityLevel.NORMAL)
    public void getSingleUser() {
        given()
                .header("x-api-key", TestConfig.API_KEY)
                .when()
                .get(TestConfig.BASE_URL + TestConfig.USERS_ENDPOINT + "/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"))
                .body("data.first_name", notNullValue());
    }
}


