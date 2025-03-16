package org.api.questions;

import org.junit.Assert;
import net.serenitybdd.rest.SerenityRest;


public class ValidateResponse {
    public static void validateStatusCode(int expectedStatusCode) {
        int actualStatusCode = SerenityRest.lastResponse().statusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    public static void validateUserId(int expectedUserId) {
        int actualUserId = SerenityRest.lastResponse().jsonPath().getInt("userId");
        Assert.assertEquals(expectedUserId, actualUserId);
    }
    public static void validateProductTitle() {
        String title = SerenityRest.lastResponse().jsonPath().getString("title");
        Assert.assertNotNull(title);
    }
}
