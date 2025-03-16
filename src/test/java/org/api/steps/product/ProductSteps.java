package org.api.steps.product;

import net.serenitybdd.core.Serenity;
import org.api.questions.ValidateResponse;
import org.api.tasks.GetProduct;
import org.api.tasks.DeleteProduct;
import org.api.utils.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.api.utils.LoggerUtil;


public class ProductSteps {
    private Actor actor;
    @Given("^(.*) relaiza una consulta de producto con el api (.*)-productos$")
    public void initializeClient(String usuario, String api) {
        actor = Actor.named(usuario)
                .whoCan(CallAnApi.at(Config.getBaseUrl()));
        LoggerUtil.info("Api a llamar de tipo  "+ api);
    }
    @When("^solicita el producto con ID (.*)$")
    public void requestProduct(int productId) {
        actor.attemptsTo(GetProduct.withId(productId));
    }

    @When("^Elimina el producto con ID (.*)$")
    public void deleteProduct(int productId) {
            actor.attemptsTo(DeleteProduct.withId(productId));
    }

    @Then("^el código de respuesta debe ser (.*)$")
    public void validateStatusCode(int statusCode) {
        ValidateResponse.validateStatusCode(statusCode);
    }

    @Then("^la respuesta debe contener el título del producto$")
    public void validateProductTitle() {
        ValidateResponse.validateProductTitle();
    }
}
