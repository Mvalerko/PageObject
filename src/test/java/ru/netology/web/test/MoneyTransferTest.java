package ru.netology.web.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.CardData;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

class MoneyTransferTest {
    BalancePage balancePage = new BalancePage();
    CardReplenishmentPage cardReplenishmentPage = new CardReplenishmentPage();

    CardData cardData = new CardData();

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
//    var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        //Configuration.headless = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
//    var loginPage = open("http://localhost:9999", LoginPageV2.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV3() {
        var loginPage = open("http://localhost:9999", LoginPageV3.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void transferMoneyTest() {
        //Configuration.headless = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        balancePage.сlickingRechargeCardOne();
        cardReplenishmentPage.setVerification();
        cardReplenishmentPage.transfer("1000", "5559 0000 0000 0002");
        System.out.println("Номер второй карты _ "+cardData.);
        balancePage.balanceUpdate();
        var cardOne = balancePage.balanceCardOne();
        var cardTwo = balancePage.balanceCardTwo();
        int expectedCardOne = 11000;
        int actualCardOne = cardOne;
        Assertions.assertEquals(expectedCardOne, actualCardOne);
        int expectedCardTwo = 9000;
        int actualCardTwo = cardTwo;
        Assertions.assertEquals(expectedCardTwo, actualCardTwo);
    }
}

