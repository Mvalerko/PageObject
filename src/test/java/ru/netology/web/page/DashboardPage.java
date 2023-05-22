package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");

  public DashboardPage() {
    heading.shouldBe(visible);
  }

  public static Integer balanceCardOne() {
    WebElement txtBoxContent = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    String preCardOne = txtBoxContent.getText();
    String cardOne = preCardOne.substring(preCardOne.lastIndexOf(':') + 1, preCardOne.indexOf('р')).trim();
    int cardOneInt = Integer.parseInt(cardOne);
    return cardOneInt;

  }

  public static Integer balanceCardTwo() {
    WebElement txtBoxContent = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    String preCardTwo = txtBoxContent.getText();
    String cardTwo = preCardTwo.substring(preCardTwo.lastIndexOf(':') + 1, preCardTwo.indexOf('р')).trim();
    int cardTwoInt = Integer.parseInt(cardTwo);
    return cardTwoInt;

  }

  public static CardReplenishmentPage сlickingRechargeCardOne() {
    SelenideElement topUp = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    topUp.click();
    return new CardReplenishmentPage();
  }
  public static CardReplenishmentPage сlickingRechargeCardTwo() {
    SelenideElement topUp = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");
    topUp.click();
    return new CardReplenishmentPage();
  }

  public static DashboardPage balanceUpdate(){
    SelenideElement reload = $("[data-test-id='action-reload']");
    reload.click();
    return new DashboardPage();
  }

}
