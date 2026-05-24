package APIBaseTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPI {

    @BeforeClass
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
    }
}

