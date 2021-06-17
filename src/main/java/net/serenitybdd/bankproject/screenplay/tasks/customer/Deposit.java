package net.serenitybdd.bankproject.screenplay.tasks.customer;

import net.serenitybdd.bankproject.screenplay.user_interface.Customer;
import net.serenitybdd.bankproject.screenplay.user_interface.CustomerAccount;
import net.serenitybdd.bankproject.screenplay.user_interface.DepositPanel;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

public class Deposit {

    public  static  Performable from_CustomerAccount(){
        return Task.where("{0} access deposit feature from Customer Account page" ,
                Click.on(CustomerAccount.DEPOSIT_BTN)
        );
    }
    public static Performable called(String amountOfMoney) {
        return Task.where("{0} deposit with amount of money: " + amountOfMoney,
                SendKeys.of(amountOfMoney).into(DepositPanel.AMOUNT_INPUT),
                Click.on(DepositPanel.DEPOSIT_BTN)
                );
    }
}
