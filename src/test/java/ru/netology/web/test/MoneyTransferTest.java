package ru.netology.web.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.CardReplenishmentPage;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPageV2;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {
    int testableSumUnits = 4;
    int testableSumTens = 13;
    int testableSumHundreds = 339;
    int testableSumThousands = 2832;

    @Test
    void transferMoneyUnitsTest() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var cardOneBeforeTransfer = DashboardPage.balanceCardOne();
        var cardTwoBeforeTransfer = DashboardPage.balanceCardTwo();
        DashboardPage.сlickingRechargeCardTwo();
        CardReplenishmentPage.setVerification();
        CardReplenishmentPage.transfer(testableSumUnits, DataHelper.getCardFirstInfo().getNumber());
        int[] expectedBalanceArray = DataHelper.expectedBalance(testableSumUnits, DataHelper.getCardFirstInfo().getNumber(),cardOneBeforeTransfer,cardTwoBeforeTransfer);
        DashboardPage.balanceUpdate();
        var cardOne = DashboardPage.balanceCardOne();
        var cardTwo = DashboardPage.balanceCardTwo();
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
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var cardOneBeforeTransfer = DashboardPage.balanceCardOne();
        var cardTwoBeforeTransfer = DashboardPage.balanceCardTwo();
        DashboardPage.сlickingRechargeCardOne();
        CardReplenishmentPage.setVerification();
        CardReplenishmentPage.transfer(testableSumHundreds, DataHelper.getCardSecondInfo().getNumber());
        int[] expectedBalanceArray = DataHelper.expectedBalance(testableSumHundreds, DataHelper.getCardSecondInfo().getNumber(),cardOneBeforeTransfer,cardTwoBeforeTransfer);
        DashboardPage.balanceUpdate();
        var cardOne = DashboardPage.balanceCardOne();
        var cardTwo = DashboardPage.balanceCardTwo();
        int expectedCardOne = expectedBalanceArray[0];
        int actualCardOne = cardOne;
        Assertions.assertEquals(expectedCardOne, actualCardOne);
        int expectedCardTwo = expectedBalanceArray[1];
        int actualCardTwo = cardTwo;
        Assertions.assertEquals(expectedCardTwo, actualCardTwo);
    }
    @Test
    void transferMoneyThousandsTest() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var cardOneBeforeTransfer = DashboardPage.balanceCardOne();
        var cardTwoBeforeTransfer = DashboardPage.balanceCardTwo();
        DashboardPage.сlickingRechargeCardOne();
        CardReplenishmentPage.setVerification();
        CardReplenishmentPage.transfer(testableSumThousands, DataHelper.getCardSecondInfo().getNumber());
        int[] expectedBalanceArray = DataHelper.expectedBalance(testableSumThousands, DataHelper.getCardSecondInfo().getNumber(),cardOneBeforeTransfer,cardTwoBeforeTransfer);
        DashboardPage.balanceUpdate();
        var cardOne = DashboardPage.balanceCardOne();
        var cardTwo = DashboardPage.balanceCardTwo();
        int expectedCardOne = expectedBalanceArray[0];
        int actualCardOne = cardOne;
        Assertions.assertEquals(expectedCardOne, actualCardOne);
        int expectedCardTwo = expectedBalanceArray[1];
        int actualCardTwo = cardTwo;
        Assertions.assertEquals(expectedCardTwo, actualCardTwo);
    }
    @Test
    void transferMoneyTensTest() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var cardOneBeforeTransfer = DashboardPage.balanceCardOne();
        var cardTwoBeforeTransfer = DashboardPage.balanceCardTwo();
        DashboardPage.сlickingRechargeCardTwo();
        CardReplenishmentPage.setVerification();
        CardReplenishmentPage.transfer(testableSumTens, DataHelper.getCardFirstInfo().getNumber());
        int[] expectedBalanceArray = DataHelper.expectedBalance(testableSumTens, DataHelper.getCardFirstInfo().getNumber(),cardOneBeforeTransfer,cardTwoBeforeTransfer);
        DashboardPage.balanceUpdate();
        var cardOne = DashboardPage.balanceCardOne();
        var cardTwo = DashboardPage.balanceCardTwo();
        int expectedCardOne = expectedBalanceArray[0];
        int actualCardOne = cardOne;
        Assertions.assertEquals(expectedCardOne, actualCardOne);
        int expectedCardTwo = expectedBalanceArray[1];
        int actualCardTwo = cardTwo;
        Assertions.assertEquals(expectedCardTwo, actualCardTwo);
    }

}

