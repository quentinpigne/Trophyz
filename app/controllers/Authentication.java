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
        User user = Form.form(User.class).bindFromRequest().get();
        return TODO;
    }

    public static Result logout() {
        return TODO;
    }

}
