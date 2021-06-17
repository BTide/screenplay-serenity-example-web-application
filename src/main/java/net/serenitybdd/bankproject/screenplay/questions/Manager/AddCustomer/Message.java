package net.serenitybdd.bankproject.screenplay.questions.Manager.AddCustomer;

import net.serenitybdd.bankproject.screenplay.user_interface.AddCustomer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class Message implements Question<String> {

    private Target target;

    private Message(Target target){
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        WebElement targetElement = target.resolveFor(actor);
        String message = BrowseTheWeb.as(actor).evaluateJavascript("return arguments[0].validationMessage", targetElement).toString();

        return message;
    }

    public static Message text(Target target) {
        return new Message(target);
    }
}
