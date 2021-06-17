package net.serenitybdd.bankproject.features.customer_transaction;

import net.serenitybdd.bankproject.screenplay.questions.Customer.Information.Customer;
import net.serenitybdd.bankproject.screenplay.questions.Customer.Transactions.Message;
import net.serenitybdd.bankproject.screenplay.tasks.Start;
import net.serenitybdd.bankproject.screenplay.tasks.customer.Deposit;
import net.serenitybdd.bankproject.screenplay.tasks.customer.Withdraw;
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
public class CustomerTransactionsTest {

        private Actor customer = Actor.named("Customer");


        String messageExceedBalanceLimit = "Transaction Failed. You can not withdraw amount more than the balance.";
        String messageDepositSuccessfully = "Deposit Successful";
        String messageWithdrawSuccessfully = "Transaction successful";

        int amount = 200;
        String depositType = "Credit";
        String withdrawType = "Debit";

        @Managed
        private WebDriver hisBrowser;

        @Before
        public void customerCanBrowseTheWebAndLogin() {
                customer.can(BrowseTheWeb.with(hisBrowser));
                givenThat(customer).wasAbleTo(Start.loginAsCustomer("Harry Potter"));
        }




        @Test
        public void depositMoneySuccessfully()
        {
                String depositAmount = "500";
                when(customer).attemptsTo(
                        Deposit.from_CustomerAccount(),
                        Deposit.called(depositAmount)
                );

                then(customer).should(
                        seeThat(Message.text(), is(messageDepositSuccessfully)),
                        seeThat(Customer.balance(), is(depositAmount))
                );
        }

        @Test
        public void WithDrawlMoneyExceedBalance() {
                String depositAmount = "500";
                String withdrawAmount = "501";
                when(customer).attemptsTo(
                        Deposit.from_CustomerAccount(),
                        Deposit.called(depositAmount),
                        Withdraw.from_CustomerAccount(),
                        Withdraw.called(withdrawAmount)
                );

                then(customer).should(
                        seeThat(Message.text(), is(messageExceedBalanceLimit))
                );
        }

        @Test
        public void WithDrawlValidAmountOfMoney() {
                String depositAmount = "500";
                String withdrawAmount = "499";
                String latestBalance = "1";
                when(customer).attemptsTo(
                        Deposit.from_CustomerAccount(),
                        Deposit.called(depositAmount),
                        Withdraw.from_CustomerAccount(),
                        Withdraw.called(withdrawAmount)
                );

                then(customer).should(
                        seeThat(Message.text(), is(messageWithdrawSuccessfully)),
                        seeThat(Customer.balance(), is(latestBalance))
                );
        }

//        @Test
//        public void ResetCustomerTransactions() {
////            customerAccountPage.deposit().withAmount(amount);
////            customerAccountPage.deposit().withAmount(amount);
////            CustomerTransactionsPage transactionPage = customerAccountPage.transactions();
////            transactionPage.reset();
////            transactionPage.verifyNumberOfTransactions(0);
//        }
}
