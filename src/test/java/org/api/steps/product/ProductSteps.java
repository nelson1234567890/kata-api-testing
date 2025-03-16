package org.api.steps.product;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
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

    @Given("^(.*) consume la API de (.*)-productos$")
    public void initializeClient(String usuario, String api) {
        actor = Actor.named(usuario)
                .whoCan(CallAnApi.at(Config.getBaseUrl()));
        LoggerUtil.info("Api a llamar de tipo  "+ api);
    }
    @When("^solicita el producto con ID (.*)$")
    public void requestProduct(int productId) {
        try {
        actor.attemptsTo(GetProduct.withId(productId));
        } catch (NumberFormatException e) {
            Serenity.recordReportData()
                    .withTitle("Error de Conversión")
                    .andContents("El ID ingresado no es válido: " + productId);
            throw e;
        }
    }

    @When("^Elimina el producto con ID (.*)$")
    public void deleteProduct(int productId) {
        try {
            actor.attemptsTo(DeleteProduct.withId(productId));
        } catch (NumberFormatException e) {
            Serenity.recordReportData()
                    .withTitle("Error de Conversión")
                    .andContents("El ID ingresado no es válido: " + productId);
            throw e;
        }
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
