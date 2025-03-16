package org.api.steps.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.api.questions.ValidateResponse;
import org.api.tasks.PutUser;
import org.api.utils.Config;
import org.api.utils.LoggerUtil;



public class UserSteps {

    private Actor actor;

    @Given("^(.*) actualiza un cliente usando el API de (.*)-users$")
    public void initializeClient(String usuario, String api) {
        actor = Actor.named(usuario)
                .whoCan(CallAnApi.at(Config.getBaseUrl()));
        LoggerUtil.info("Api a llamar de tipo "+ api);
    }

    @When("^actualiza un usuario con ID (.*)$")
    public void requestUser(int userId) {
            actor.attemptsTo(PutUser.withId(userId));
    }

    @Then("^la respuesta del api es el codigo http (.*)$")
    public void validateStatusCode(int statusCode) {
        ValidateResponse.validateStatusCode(statusCode);
    }
}
