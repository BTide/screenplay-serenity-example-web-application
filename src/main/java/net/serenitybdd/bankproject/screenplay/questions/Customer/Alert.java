package net.serenitybdd.bankproject.screenplay.questions.Customer;

import net.serenitybdd.bankproject.screenplay.model.AccountInformation;
import net.serenitybdd.bankproject.screenplay.questions.Customer.Information.Customer;
import net.serenitybdd.bankproject.screenplay.user_interface.CustomerAccount;
import net.serenitybdd.bankproject.screenplay.user_interface.DepositPanel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

public class Alert implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        String alertContent = BrowseTheWeb.as(actor).getAlert().getText();

        return alertContent;
    }

    public static Alert text() {
        return new Alert();
    }

}
