package net.serenitybdd.bankproject.screenplay.tasks.customer;

import net.serenitybdd.bankproject.screenplay.user_interface.CustomerAccount;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Logout {
    public static Performable called() {
        return Task.where("{0} logout",
                Click.on(CustomerAccount.LOGOUT_BUTTON));
    }
}
