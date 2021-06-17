package net.serenitybdd.bankproject.screenplay.tasks.manager;

import net.serenitybdd.bankproject.screenplay.user_interface.AddCustomer;
import net.serenitybdd.bankproject.screenplay.user_interface.Manager;
import net.serenitybdd.screenplay.ClickInteraction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

public class AddNewCustomer {
    public static Performable from_ManagerPage(){
        return Task.where("Add new customer", Click.on(Manager.ADD_CUSTOMER_BUTTON));
    }

    public static Performable called(String firstName, String lastName, String postCode) {
        return Task.where("{0} add a new customer",
                SendKeys.of(firstName).into(AddCustomer.FIRST_NAME_INPUT),
                SendKeys.of(lastName).into(AddCustomer.LAST_NAME_INPUT),
                SendKeys.of(postCode).into(AddCustomer.POST_CODE_INPUT),
                Click.on(AddCustomer.SUBMIT_BTN));
    }
}
