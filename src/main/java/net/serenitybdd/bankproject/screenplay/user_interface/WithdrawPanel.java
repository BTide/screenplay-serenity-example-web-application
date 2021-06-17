package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class WithdrawPanel {
    public static final Target AMOUNT_INPUT = Target.the("Withdraw amount").locatedBy("//form[@ng-submit='withdrawl()']//input");
    public static final Target WITHDRAW_BTN = Target.the("Withdraw button").locatedBy("//form/button[text()='Withdraw']");

}
