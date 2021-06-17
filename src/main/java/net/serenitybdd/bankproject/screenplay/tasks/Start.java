package net.serenitybdd.bankproject.screenplay.tasks;

import net.serenitybdd.bankproject.screenplay.user_interface.CustomerLogin;
import net.serenitybdd.bankproject.screenplay.user_interface.Home;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;


import static net.serenitybdd.bankproject.screenplay.user_interface.CustomerLogin.LOGIN_BTN;
import static net.serenitybdd.bankproject.screenplay.user_interface.CustomerLogin.YOUR_NAME_SELECT;


public class Start {

    public static Performable loginAsCustomer(String yourName) {
        return Task.where("{0} starts login as a customer",
                Open.browserOn().thePageNamed("home.page"),
                Click.on(Home.CUSTOMER_LOGIN_BUTTON),
                SelectFromOptions.byVisibleText(yourName).from(YOUR_NAME_SELECT),
                Click.on(LOGIN_BTN)
        );
    }


    public   static  Performable LoginAsManager(){
       return Task.where("{0} start login as a manager",
               Open.browserOn().thePageNamed("home.page"),
               Click.on(Home.BANK_MANAGER_LOGIN_BUTTON)
       );
    }

}
