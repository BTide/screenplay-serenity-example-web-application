package net.serenitybdd.bankproject.screenplay.user_interface;


import net.serenitybdd.screenplay.targets.Target;

public class CustomerLogin {
    public static final Target YOUR_NAME_SELECT = Target.the("Your Name select").locatedBy("#userSelect");
    public static final Target LOGIN_BTN = Target.the("Login button").locatedBy("//button[text()='Login']");
  
}
