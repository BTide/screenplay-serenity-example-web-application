package net.serenitybdd.bankproject.screenplay.tasks.customer;

import net.serenitybdd.bankproject.screenplay.user_interface.CustomerAccount;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SelectAccountNumber {
    public static Performable called(String accountNumber) {
        return Task.where("{0} select account number" + accountNumber,
                SelectFromOptions.byVisibleText(accountNumber).from(CustomerAccount.ACCOUNT_SELECT));
    }
}
