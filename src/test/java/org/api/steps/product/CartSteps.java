package org.api.steps.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.api.tasks.PostCarts;
import org.api.questions.ValidateResponse;
import org.api.utils.Config;
import org.api.utils.LoggerUtil;


public class CartSteps {
    private Actor actor;

    @Given("^(.*) crea un cart al consumir el API tipo post de (.*)-carts$")
    public void initializeClient(String usuario, String api) {
        actor = Actor.named(usuario)
                .whoCan(CallAnApi.at(Config.getBaseUrl()));
        LoggerUtil.info("Api a llamar de tipo "+ api);
    }
    @When("^crear un cart con el (.*) y productos especificados$")
    public void createProductWithJsonFile(int userId) {
        actor.attemptsTo(PostCarts.withId(userId));
    }

    @Then("^la respuesta debe tener codigo http (.*)$")
    public void validateStatusCode(int statusCode) {
        ValidateResponse.validateStatusCode(statusCode);
    }

    @Then("^la respuesta debe contener el id del (.*)$")
    public void validateProductTitle(int idUser) {
        ValidateResponse.validateUserId(idUser);
    }
}
