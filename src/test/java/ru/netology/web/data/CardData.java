package ru.netology.web.data;

import lombok.Value;

@Value
public class CardData {

    String cardFirst = "5559 0000 0000 0001";
    String cardSecond = "5559 0000 0000 0002";

    /*@Value
    public static class CardInfo {
        private String number;
    }

    public static CardInfo getCardFirstInfo() {
        return new CardInfo("5559 0000 0000 0001");
    }
    public static CardInfo getCardSecondInfo() {
        return new CardInfo("5559 0000 0000 0002");
    }

     */

}
