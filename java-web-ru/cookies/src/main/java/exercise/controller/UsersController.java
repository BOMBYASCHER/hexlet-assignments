package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import exercise.repository.UserRepository;

import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = StringUtils.capitalize(ctx.formParam("firstName"));
        var lastName = StringUtils.capitalize(ctx.formParam("lastName"));
        var email = ctx.formParam("email").trim().toLowerCase();
        var password = ctx.formParam("password");
        var token = Security.generateToken();
        ctx.cookie("token", token);
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        var id = user.getId();
        ctx.redirect(NamedRoutes.userPath(String.valueOf(id)));
    }

    public static void show(Context ctx) {
        var token = ctx.cookie("token");
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id);
        var userToken = user.getToken();
        if (userToken.equals(token)) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
