package ru.netology.web.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.CardData;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

class MoneyTransferTest {
    int testableSumUnits = 4;
    int testableSumTens = 13;
    int testableSumHundreds = 339;
    int testableSumThousands = 2832;

    BalancePage balancePage = new BalancePage();
    CardReplenishmentPage cardReplenishmentPage = new CardReplenishmentPage();
    CardData cardData = new CardData();

    @Test
    void transferMoneyUnitsTest() {
        Configuration.headless = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        //balancePage.сlickingRechargeCardOne();
        var cardOneBeforeTransfer = balancePage.balanceCardOne();
        var cardTwoBeforeTransfer = balancePage.balanceCardTwo();
        balancePage.сlickingRechargeCardTwo();
        cardReplenishmentPage.setVerification();
        cardReplenishmentPage.transfer(testableSumUnits, CardData.getCardFirstInfo().getNumber());
        int[] expectedBalanceArray = cardData.expectedBalance(testableSumUnits, CardData.getCardFirstInfo().getNumber(),cardOneBeforeTransfer,cardTwoBeforeTransfer);
        balancePage.balanceUpdate();
        var cardOne = balancePage.balanceCardOne();
        var cardTwo = balancePage.balanceCardTwo();
        int expectedCardOne = expectedBalanceArray[0];
        int actualCardOne = cardOne;
        Assertions.assertEquals(expectedCardOne, actualCardOne);
        int expectedCardTwo = expectedBalanceArray[1];
        int actualCardTwo = cardTwo;
        Assertions.assertEquals(expectedCardTwo, actualCardTwo);
    }
    //@Disabled
    @Test
    void transferMoneyHundredsTest() {
        Configuration.headless = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var cardOneBeforeTransfer = balancePage.balanceCardOne();
        var cardTwoBeforeTransfer = balancePage.balanceCardTwo();
        balancePage.сlickingRechargeCardOne();
        cardReplenishmentPage.setVerification();
        cardReplenishmentPage.transfer(testableSumHundreds, CardData.getCardSecondInfo().getNumber());
        int[] expectedBalanceArray = cardData.expectedBalance(testableSumHundreds, CardData.getCardSecondInfo().getNumber(),cardOneBeforeTransfer,cardTwoBeforeTransfer);
        balancePage.balanceUpdate();
        var cardOne = balancePage.balanceCardOne();
        var cardTwo = balancePage.balanceCardTwo();
        int expectedCardOne = expectedBalanceArray[0];
        int actualCardOne = cardOne;
        Assertions.assertEquals(expectedCardOne, actualCardOne);
        int expectedCardTwo = expectedBalanceArray[1];
        int actualCardTwo = cardTwo;
        Assertions.assertEquals(expectedCardTwo, actualCardTwo);
    }
    @Test
    void transferMoneyThousandsTest() {
        Configuration.headless = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var cardOneBeforeTransfer = balancePage.balanceCardOne();
        var cardTwoBeforeTransfer = balancePage.balanceCardTwo();
        balancePage.сlickingRechargeCardOne();
        cardReplenishmentPage.setVerification();
        cardReplenishmentPage.transfer(testableSumThousands, CardData.getCardSecondInfo().getNumber());
        int[] expectedBalanceArray = cardData.expectedBalance(testableSumThousands, CardData.getCardSecondInfo().getNumber(),cardOneBeforeTransfer,cardTwoBeforeTransfer);
        balancePage.balanceUpdate();
        var cardOne = balancePage.balanceCardOne();
        var cardTwo = balancePage.balanceCardTwo();
        int expectedCardOne = expectedBalanceArray[0];
        int actualCardOne = cardOne;
        Assertions.assertEquals(expectedCardOne, actualCardOne);
        int expectedCardTwo = expectedBalanceArray[1];
        int actualCardTwo = cardTwo;
        Assertions.assertEquals(expectedCardTwo, actualCardTwo);
    }
    @Test
    void transferMoneyTensTest() {
        Configuration.headless = true;
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        //balancePage.сlickingRechargeCardOne();
        var cardOneBeforeTransfer = balancePage.balanceCardOne();
        var cardTwoBeforeTransfer = balancePage.balanceCardTwo();
        balancePage.сlickingRechargeCardTwo();
        cardReplenishmentPage.setVerification();
        cardReplenishmentPage.transfer(testableSumTens, CardData.getCardFirstInfo().getNumber());
        int[] expectedBalanceArray = cardData.expectedBalance(testableSumTens, CardData.getCardFirstInfo().getNumber(),cardOneBeforeTransfer,cardTwoBeforeTransfer);
        balancePage.balanceUpdate();
        var cardOne = balancePage.balanceCardOne();
        var cardTwo = balancePage.balanceCardTwo();
        int expectedCardOne = expectedBalanceArray[0];
        int actualCardOne = cardOne;
        Assertions.assertEquals(expectedCardOne, actualCardOne);
        int expectedCardTwo = expectedBalanceArray[1];
        int actualCardTwo = cardTwo;
        Assertions.assertEquals(expectedCardTwo, actualCardTwo);
    }
}

