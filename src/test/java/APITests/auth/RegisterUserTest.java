package APITests.auth;

import APIBaseTest.BaseAPI;
import config.TestConfig;
import data.TestData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@Epic("ReqRes API Testing")
@Feature("Authentication")
@Story("POST Register User")

public class RegisterUserTest extends BaseAPI {

    //================ Test 4 Inregistreaza user ====================//
    //1. Pregatește payload-ul JSON cu email si parola.
    //2. Trimițe un request POST catre /api/register.
    //3. Trimițe header-ul x-api-key cu cheia generata.
    //4. Verifica ca raspunsul este 200.
    //5. Verifica ca raspunsul contine un id.
    //6. Verifica ca raspunsul contine un token.

    @Test
    @Description("Inregistreaza un utilizator si verifica faptul ca ID-ul si token-ul sunt returnate")
    @Severity(SeverityLevel.CRITICAL)
    public void registerUser() {

        String payload = "{\n" +
                "  \"email\": \"" + TestData.REGISTER_EMAIL + "\",\n" +
                "  \"password\": \"" + TestData.REGISTER_PASSWORD + "\"\n" +
                "}";

        given()
                .header("x-api-key", TestConfig.API_KEY)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(TestConfig.BASE_URL + "/api/register")
                .then()
                .statusCode(200).body("id", notNullValue())
                .body("token", notNullValue());
    }
}
