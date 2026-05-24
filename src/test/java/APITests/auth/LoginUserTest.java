package APITests.auth;

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
@Story("POST Login User")

public class LoginUserTest extends BaseAPI {

    //================= Test 5 =================//
    //1. Pregateste payload-ul JSON cu email si parola valide.
    //2. Trimițe un request POST catre /api/login.
    //3. Trimițe header-ul x-api-key cu cheia generata.
    //4. Verifica ca raspunsul este 200.
    //5. Verifica ca raspunsul contine un token.

    @Test
    @Description("Autentifica un utilizator si verifica faptul ca token-ul este returnat")
    @Severity(SeverityLevel.CRITICAL)
    public void loginUser() {

        String payload = "{\n" +
                "  \"email\": \"" + TestData.LOGIN_EMAIL + "\",\n" +
                "  \"password\": \"" + TestData.LOGIN_PASSWORD + "\"\n" +
                "}";

        given()
                .header("x-api-key", TestConfig.API_KEY)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(TestConfig.BASE_URL + "/api/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue());

    }

    //================ Test 6 ==================//
    //1. Pregatește payload-ul JSON fara parola.
    //2. Trimițe un request POST catre /api/login.
    //3. Trimițe header-ul x-api-key cu cheia generata.
    //4. Verifica ca raspunsul este 400.
    //5. Verifica ca mesajul de eroare este “Missing password”.

    @Test
    @Description("Incearca autentificarea fara parola si verifica faptul ca serverul returneaza eroarea corecta")
    @Severity(SeverityLevel.NORMAL)
    public void loginUserMissingPassword() {

        String payload = "{\n" +
                "  \"email\": \"" + TestData.LOGIN_EMAIL_NO_PASSWORD + "\"\n" +
                "}";

        given()
                .header("x-api-key", TestConfig.API_KEY)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(TestConfig.BASE_URL + "/api/login")
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

}
