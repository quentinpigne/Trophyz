package controllers;

import models.User;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        Form<User> userForm = Form.form(User.class);
        return ok(index.render(userForm));
    }

}
