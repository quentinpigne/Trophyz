package controllers;

import models.User;
import play.data.Form;
import play.mvc.*;

public class Authentication extends Controller {

    public static Result signup() {
        User newUser = Form.form(User.class).bindFromRequest().get();
        return TODO;
    }

    public static Result login() {
        User user = User.logUser(Form.form(User.class).bindFromRequest().get());
        if(user != null) return ok("User connecté : " + user.userFirstName + " " + user.userLastName);
        return notFound("User inconnu");
    }

    public static Result logout() {
        return TODO;
    }

}
