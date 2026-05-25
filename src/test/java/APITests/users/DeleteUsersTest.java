package APITests.users;

import APIBaseTest.BaseAPI;
import config.TestConfig;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("ReqRes API Testing")
@Feature("User Management")
@Story("DELETE User")

public class DeleteUsersTest extends BaseAPI {

    //============== Test 6 Sterge user ===========//
    //1. Trimițe DELETE catre /api/users2.
    //2. Verifica status 204.
    //3. Verifica ca raspunsul nu contine body.

    @Test
    @Description("Sterge utilizatorul cu ID 2 si verifica faptul ca raspunsul este 204")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteUser() {
        given()
                .header("x-api-key", TestConfig.API_KEY)
                .when()
                .delete(TestConfig.BASE_URL + TestConfig.USERS_ENDPOINT + "/2")
                .then()
                .statusCode(204)
                .body(equalTo(""));

    }

}
