package net.serenitybdd.bankproject.features;

import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class WebHook {
    protected Actor customer = Actor.named("Customer");
    protected Actor manager = Actor.named("Manager");


    @Managed
    protected WebDriver hisBrowser;

}
