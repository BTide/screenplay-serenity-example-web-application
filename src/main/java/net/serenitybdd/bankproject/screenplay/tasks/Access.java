package net.serenitybdd.bankproject.screenplay.tasks;

import net.serenitybdd.bankproject.screenplay.user_interface.Home;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.bankproject.screenplay.user_interface.CustomerLogin.LOGIN_BTN;
import static net.serenitybdd.bankproject.screenplay.user_interface.CustomerLogin.YOUR_NAME_SELECT;

public class Access {
    public static Performable call(String url) {
        return Task.where("{0} access page " + url,
                Open.browserOn().thePageNamed(url)
        );
    }
}
