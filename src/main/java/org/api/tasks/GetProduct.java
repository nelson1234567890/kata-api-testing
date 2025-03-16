package org.api.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.api.utils.LoggerUtil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetProduct implements Task {
    private final int productId;

    public GetProduct(int productId) {
        this.productId = productId;
    }

    public static GetProduct withId(int productId) {
        return instrumented(GetProduct.class, productId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if(productId == 3){
            actor.attemptsTo(
                    Get.resource("/products/{id}")
                            .with(request -> request
                                    .pathParam("id", productId)
                                    .contentType(ContentType.JSON))
            );
            LoggerUtil.info("Response: " + SerenityRest.lastResponse().asString());
        }else{
            actor.attemptsTo(
                    Get.resource("/products/{id}")
                            .with(request -> request
                                    .pathParam("id", 9)
                                    .contentType(ContentType.JSON))
            );
            LoggerUtil.info("Response: " + SerenityRest.lastResponse().asString());
        }

        }


}