package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CardReplenishmentPage {
    private SelenideElement verificationElement = $(".heading_size_xl");
    private SelenideElement amount = $("[data-test-id='amount'] > [data-test-id='amount'] input");
    private SelenideElement from = $("[data-test-id='from'] input");
    private SelenideElement transfer = $("[data-test-id='action-transfer']");

    public void setVerification() {
        verificationElement.shouldHave(Condition.text("Пополнение карты"), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }

    public void transfer(String amountTop, String fromCard) {
        amount.click();
        amount.setValue(amountTop);
        from.click();
        from.setValue(fromCard);
        transfer.click();
    }
}
