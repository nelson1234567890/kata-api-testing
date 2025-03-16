package org.api.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.api.utils.LoggerUtil;

public class PostCarts implements Task {

    private final int userId;

    public PostCarts(int userId) {
        this.userId = userId;
    }

    public static PostCarts withId(int userId) {
        return instrumented(PostCarts.class, userId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        File jsonFile = new File("src/test/resources/jsonFiles/cart.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            if (jsonNode instanceof ObjectNode) {
                ObjectNode objectNode = (ObjectNode) jsonNode;
                if (userId >10){
                    objectNode.put("userId", 100);
                }else{
                    objectNode.put("userId", userId);
                }

            }
            String jsonBody = objectMapper.writeValueAsString(jsonNode);
            actor.attemptsTo(
                    Post.to("/carts")
                            .with(request -> request
                                    .contentType("application/json")
                                    .body(jsonBody))
            );

            LoggerUtil.info("Response: " + SerenityRest.lastResponse().asString());
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el JSON", e);
        }
    }
}
