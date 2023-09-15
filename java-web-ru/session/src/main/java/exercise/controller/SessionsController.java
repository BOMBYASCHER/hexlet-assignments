package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var currentUser = ctx.sessionAttribute("currentUser");
        var page = new MainPage(currentUser);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var currentUser = ctx.sessionAttribute("currentUser");
        var page = new LoginPage(String.valueOf(currentUser), null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        if (UsersRepository.existsByName(name)) {
            var user = UsersRepository.findByName(name);
            var userPassword = user.getPassword();
            if (userPassword.equals(encrypt(password))) {
                ctx.sessionAttribute("currentUser", name);
                ctx.redirect("/");
            } else {
                var page = new LoginPage(name, "Wrong username or password");
                ctx.render("build.jte", Collections.singletonMap("page", page));
            }
        } else {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }

    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
