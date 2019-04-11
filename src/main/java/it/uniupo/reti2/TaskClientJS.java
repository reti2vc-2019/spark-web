package it.uniupo.reti2;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class TaskClientJS {

    public static void main(String[] args) {

        // location for js, css, png, ... files
        staticFileLocation("/static");
        // change the default port
        port(5000);

        get("/", (req, res) ->{
            // we don't need to fill a model, here, since everything is handled by js
            Map emptyModel = new HashMap();

            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(emptyModel, "js-view/tasks.hbs"));

        });
    }
}
