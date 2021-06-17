package net.serenitybdd.bankproject.screenplay.tasks.customer;

import net.serenitybdd.bankproject.screenplay.user_interface.CustomerAccount;
import net.serenitybdd.bankproject.screenplay.user_interface.WithdrawPanel;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

public class Withdraw {

    public static Performable from_CustomerAccount() {
        return Task.where("{0} access withdraw feature from Customer Account page",
                Click.on(CustomerAccount.WITHDRAW_BTN));
    }
    public static Performable called(String amountOfMoney) {

        return Task.where("{0} withdraw with amount of money: " + amountOfMoney,
                SendKeys.of(amountOfMoney).into(WithdrawPanel.AMOUNT_INPUT),
                Click.on(WithdrawPanel.WITHDRAW_BTN));
    }
}
