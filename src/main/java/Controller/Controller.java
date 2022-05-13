package Controller;

import io.javalin.Javalin;

import javax.xml.xpath.XPath;

public class Controller {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        app.start(4100);

        app.get("/", ctx ->
            ctx.result("Hello Server!")
        );
    }


}
