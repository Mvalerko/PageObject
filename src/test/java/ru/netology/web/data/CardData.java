package ru.netology.web.data;

import lombok.Value;

public class CardData {
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
