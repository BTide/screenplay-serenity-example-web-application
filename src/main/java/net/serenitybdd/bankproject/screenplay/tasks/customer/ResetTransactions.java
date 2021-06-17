package net.serenitybdd.bankproject.screenplay.tasks.customer;

import net.serenitybdd.bankproject.screenplay.user_interface.CustomerAccount;
import net.serenitybdd.bankproject.screenplay.user_interface.CustomerTransactions;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ResetTransactions {
    public static Performable called(String amountOfMoney) {
        return Task.where("{0} reset transaction table",
                Click.on(CustomerTransactions.RESET_BUTTON));
    }
}
