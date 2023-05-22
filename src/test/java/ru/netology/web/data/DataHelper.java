package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
  private DataHelper() {}

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  public static AuthInfo getAuthInfo() {
      return new AuthInfo("vasya", "qwerty123");
  }

  public static AuthInfo getOtherAuthInfo(AuthInfo original) {
    return new AuthInfo("petya", "123qwerty");
  }

  @Value
  public static class VerificationCode {
    private String code;
  }

  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
    return new VerificationCode("12345");
  }

  public static int[] expectedBalance(int chargeAmount, String chargeСard, int originalCardOneBalance, int originalCardTwoBalance) {
    int[] expectedBalanceArray = new int[2];
    if (chargeСard.equals(DataHelper.getCardFirstInfo().getNumber())) {
      expectedBalanceArray[0] = originalCardOneBalance - chargeAmount;
      expectedBalanceArray[1] = originalCardTwoBalance + chargeAmount;
      return expectedBalanceArray;
    } else {
      expectedBalanceArray[0] = originalCardOneBalance + chargeAmount;
      expectedBalanceArray[1] = originalCardTwoBalance - chargeAmount;
      return expectedBalanceArray;
    }
  }


  @Value
  public static class CardInfo {
    private String number;
  }

  public static DataHelper.CardInfo getCardFirstInfo() {
    return new CardInfo("5559 0000 0000 0001");
  }

  public static DataHelper.CardInfo getCardSecondInfo() {
    return new CardInfo("5559 0000 0000 0002");
  }

}
