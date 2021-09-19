package net.serenitybdd.bankproject.features.manage_customer;

import net.serenitybdd.bankproject.features.WebHook;
import net.serenitybdd.bankproject.screenplay.model.CustomerInformation;
import net.serenitybdd.bankproject.screenplay.questions.Customer.Alert;
import net.serenitybdd.bankproject.screenplay.questions.Manager.AddCustomer.Message;
import net.serenitybdd.bankproject.screenplay.tasks.Start;
import net.serenitybdd.bankproject.screenplay.tasks.manager.AddNewCustomer;
import net.serenitybdd.bankproject.screenplay.user_interface.AddCustomer;
import net.serenitybdd.bankproject.screenplay.user_interface.Customer;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.core.Is.is;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("Screenplay pattern"),
})
public class AddNewCustomerTest extends WebHook {

    String errorMessage = "Please fill out this field.";
    String successMessage = "Customer added successfully with customer id :";

    CustomerInformation customer = new CustomerInformation("B","Tide","123");

    @Before
    public void managerCanBrowseTheWebAndLogin() {

        manager.can(BrowseTheWeb.with(hisBrowser));

        givenThat(manager).attemptsTo(Start.LoginAsManager());
    }

    @Test
    public void should_be_able_to_add_a_new_customer() {
        when(manager).attemptsTo(
                AddNewCustomer.from_ManagerPage(),
                AddNewCustomer.called(customer)
        );

        then(manager).should(
                seeThat(Alert.text(), is(successMessage+ "6"))
        );

        //teardown
        BrowseTheWeb.as(manager).getAlert().accept();
    }

    @Test
    public void should_validate_first_mane() {
        customer.setFirstName("");

        when(manager).attemptsTo(
                AddNewCustomer.from_ManagerPage(),
                AddNewCustomer.called(customer)
        );

        then(manager).should(
                seeThat(Message.text(AddCustomer.FIRST_NAME_INPUT), is(errorMessage))
        );

    }

    @Test
    public void should_validate_last_name() {
        customer.setLastName("");

        when(manager).attemptsTo(
                AddNewCustomer.from_ManagerPage(),
                AddNewCustomer.called(customer)
        );

        then(manager).should(
                seeThat(Message.text(AddCustomer.LAST_NAME_INPUT), is(errorMessage))
        );
    }

    @Test
    public void should_validate_post_code() {
        customer.setPostCode("");

        when(manager).attemptsTo(
                AddNewCustomer.from_ManagerPage(),
                AddNewCustomer.called(customer)
        );

        then(manager).should(
                seeThat(Message.text(AddCustomer.POST_CODE_INPUT), is(errorMessage))
        );
    }
}
