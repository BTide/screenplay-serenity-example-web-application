package net.serenitybdd.bankproject.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class DepositPanel {
    public static final Target AMOUNT_INPUT = Target.the("Deposit amount").locatedBy("//form[@ng-submit='deposit()']//input");
    public static final Target DEPOSIT_BTN = Target.the("Deposit button").locatedBy("//form/button[text()='Deposit']");
    public static final Target MESSAGE_TXT = Target.the("Message text").locatedBy(".error");

}
