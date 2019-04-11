package it.uniupo.reti2;

import org.springframework.web.client.RestTemplate;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

import static spark.Spark.*;

public class TaskClient {

    public static void main(String[] args) {

        // change the default port
        port(5000);
        // init resttemplate
        RestTemplate rest = new RestTemplate();

        get("/", (req, res) ->{
            // get and parse the JSON from the "external" server
            Map model = rest.getForObject("http://localhost:4567/api/v1.0/tasks", Map.class);

            // handle the views
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "tasks.hbs"));

        });
    }
}
