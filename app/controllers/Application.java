package controllers;

import models.User;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import static play.data.Form.form;

public class Application extends Controller {

    public static class Login{
        public String email;
        public String password;
    }
    public static  User loggedUser = null;
    public static Result index() {
        Form<User> userForm = Form.form(User.class);
        return ok(index.render(userForm));
    }

    public static Result login() {
        return ok(login.render(form(Login.class)));
    }

    public static Result logout() {
        session().clear();
        loggedUser = null;
        return redirect(routes.Application.index());
    }
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        String email = loginForm.get().email;
        String password = loginForm.get().password;
        loggedUser = User.authenticate(email, password);
        if (loggedUser == null){
            session().clear();
            return badRequest("invalid password");
        }
        session().clear();
        session("email", email);
        return ok(test.render(loggedUser));

    }
}
