package net.serenitybdd.bankproject.screenplay.questions.Customer.Transactions;

import net.serenitybdd.bankproject.screenplay.user_interface.DepositPanel;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class Message {
    public static Question<String> text() {
        return Text.of(DepositPanel.MESSAGE_TXT)
                .describedAs("Transaction  status")
                .asAString();
    }
}
