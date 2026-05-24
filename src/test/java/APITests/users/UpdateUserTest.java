package APITests.users;

import APIBaseTest.BaseAPI;
import config.TestConfig;
import data.TestData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Epic("ReqRes API Testing")
@Feature("User Management")
@Story("PUT Update User")

public class UpdateUserTest extends BaseAPI {
    //================ Test 7 ================//
    //1. Creaza payload cu nume și job noi.
    //2. Trimițe PUT catre /api/users/2.
    //3. Verifica status 200.
    //4. Verifica ca numele și job-ul au fost actualizate.
    //5. Verifica ca există campul updatedAt.

    @Test
    @Description("Actualizeaza complet utilizatorul cu ID 2 si verifica numele, job-ul și timestamp-ul")
    @Severity(SeverityLevel.CRITICAL)
    public void updateUser() {

        String payload = "{\n" +
                "  \"name\": \"" + TestData.USER_NAME_UPDATED + "\",\n" +
                "  \"job\": \"" + TestData.USER_JOB_UPDATED + "\"\n" +
                "}";

        given()
                .header("x-api-key", TestConfig.API_KEY)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .put(TestConfig.BASE_URL + "/api/users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("Iulia Updated"))
                .body("job", equalTo("Senior QA"))
                .body("updatedAt", notNullValue());
    }
}


