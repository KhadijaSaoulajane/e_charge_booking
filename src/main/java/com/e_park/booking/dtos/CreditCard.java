package com.e_park.booking.dtos;

public class CreditCard {

    private Long id;
    private String card_holder;
    private String card_number;
    private String card_exp;
    private String card_cvv;

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_exp() {
        return card_exp;
    }

    public void setCard_exp(String card_exp) {
        this.card_exp = card_exp;
    }

    public String getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(String card_cvv) {
        this.card_cvv = card_cvv;
    }

    public CreditCard(String card_holder, String card_number, String card_exp, String card_cvv) {
        this.card_holder = card_holder;
        this.card_number = card_number;
        this.card_exp = card_exp;
        this.card_cvv = card_cvv;
    }
}
