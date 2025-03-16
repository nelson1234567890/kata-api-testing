package org.api.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.api.utils.LoggerUtil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteProduct implements Task {
    private final int productId;
    public DeleteProduct(int productId) {
        this.productId = productId;
    }

    public static DeleteProduct withId(int productId) {
        return instrumented(DeleteProduct.class, productId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/products/{id}")
                        .with(request -> request
                                .pathParam("id", productId)
                                .contentType(ContentType.JSON))
        );
        LoggerUtil.info("Response: " + SerenityRest.lastResponse().asString());
    }
}
