package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.text.DecimalFormat;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CardReplenishmentPage {
    private static SelenideElement verificationElement = $(".heading_size_xl");
    private static SelenideElement amount = $("[data-test-id='amount'] > [data-test-id='amount'] input");
    private static SelenideElement from = $("[data-test-id='from'] input");
    private static SelenideElement transfer = $("[data-test-id='action-transfer']");

    public static void setVerification() {
        verificationElement.shouldHave(Condition.text("Пополнение карты"), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }

    public static DashboardPage transfer(int amountTop, String fromCard) {
        DecimalFormat DFormat = new DecimalFormat("#");
        String amountTopString = DFormat.format(amountTop);
        amount.click();
        amount.setValue(amountTopString);
        from.click();
        from.setValue(fromCard);
        transfer.click();
        return new DashboardPage();
    }
}
