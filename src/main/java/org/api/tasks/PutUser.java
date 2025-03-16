package org.api.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.api.utils.LoggerUtil;
import java.io.File;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUser implements Task {
    private final int userId;

    public PutUser(int userID) {
        this.userId = userID;
    }

    public static PutUser withId(int productId) {
        return instrumented(PutUser.class, productId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        File jsonFile = new File("src/test/resources/jsonFiles/user.json");
        if (userId >10){
            actor.attemptsTo(
                    Put.to("/users/{id}")
                            .with(request -> request
                                    .pathParam("id", "malData")
                                    .contentType(ContentType.JSON)
                                    .body(jsonFile))
            );
            LoggerUtil.info("Response: " + SerenityRest.lastResponse().asString());
        }else{
            actor.attemptsTo(
                    Put.to("/users/{id}")
                            .with(request -> request
                                    .pathParam("id", userId)
                                    .contentType(ContentType.JSON)
                                    .body(jsonFile))
            );
            LoggerUtil.info("Response: " + SerenityRest.lastResponse().asString());
        }
    }
}
