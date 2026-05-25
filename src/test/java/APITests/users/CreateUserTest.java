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
@Story("POST Create User")

public class CreateUserTest extends BaseAPI {

    //================== Test 3 Creeaza user =================//
    //1. Creaza payload-ul JSON cu nume și job.
    //2. Trimițe POST catre /api/users.
    //3. Verifica status 201.
    //4. Verifica ca numele din raspuns este cel trimis.
    //5. Verifica ca job-ul este cel trimis.
    //6. Verifica ca serverul a generat un ID.

    @Test
    @Description("Creeaza un utilizator nou si verifică faptul ca numele, job-ul și ID-ul sunt returnate corect")
    @Severity(SeverityLevel.CRITICAL)
    public void createUser() {

        String payload = "{\n" +
                "  \"name\": \"" + TestData.USER_NAME + "\",\n" +
                "  \"job\": \"" + TestData.USER_JOB + "\"\n" +
                "}";

        given()
                .header("x-api-key", TestConfig.API_KEY)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(TestConfig.BASE_URL + TestConfig.USERS_ENDPOINT)
                .then()
                .statusCode(201)
                .body("name", equalTo("Iulia"))
                .body("job", equalTo("QA"))
                .body("id", notNullValue());
    }

}
