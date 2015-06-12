package controllers;

import com.avaje.ebean.Ebean;
import models.User;
import play.data.Form;
import play.mvc.*;
import views.html.login;

import static play.data.Form.form;

public class Authentication extends Controller {

    public static Result signup() {
        User newUser = form(User.class).bindFromRequest().get();
        Ebean.save(newUser);
        return ok(newUser.userUserName);
    }



    public static Result logout() {
        return TODO;
    }

    public static Result authenticate() {
        User user = User.logUser(form(User.class).bindFromRequest().get());
        if(user != null) return ok("User connecté : " + user.userFirstName + " " + user.userLastName);
        return notFound("User inconnu");
    }
}
