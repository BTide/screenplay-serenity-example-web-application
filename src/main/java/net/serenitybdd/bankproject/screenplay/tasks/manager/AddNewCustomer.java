package net.serenitybdd.bankproject.screenplay.tasks.manager;

import net.serenitybdd.bankproject.screenplay.model.CustomerInformation;
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

    public static Performable called(CustomerInformation customer) {
        return Task.where("{0} add a new customer",
                SendKeys.of(customer.getFirstName()).into(AddCustomer.FIRST_NAME_INPUT),
                SendKeys.of(customer.getLastName()).into(AddCustomer.LAST_NAME_INPUT),
                SendKeys.of(customer.getPostCode()).into(AddCustomer.POST_CODE_INPUT),
                Click.on(AddCustomer.SUBMIT_BTN));
    }
}
