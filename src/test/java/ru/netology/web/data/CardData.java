package ru.netology.web.data;

import lombok.Value;


public class CardData {

    public int[] expectedBalance(int chargeAmount, String chargeСard, int originalCardOneBalance, int originalCardTwoBalance) {
        int[] expectedBalanceArray = new int[2];
        if (chargeСard == CardData.getCardFirstInfo().getNumber()) {
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

    public static CardInfo getCardFirstInfo() {
        return new CardInfo("5559 0000 0000 0001");
    }

    public static CardInfo getCardSecondInfo() {
        return new CardInfo("5559 0000 0000 0002");
    }

}
