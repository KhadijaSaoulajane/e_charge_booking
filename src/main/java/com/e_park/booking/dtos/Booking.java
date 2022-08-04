package com.e_park.booking.dtos;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String user_id;
    @Column(name = "cs_id")
    private String cs_id;
    @Column(name = "cardHolderName")
    private String cardHolderName;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "expDate")
    private String expDate;
    @Column(name = "cvv")
    private String cvv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCs_id() {
        return cs_id;
    }

    public void setCs_id(String cs_id) {
        this.cs_id = cs_id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Booking(String user_id, String cs_id, String cardHolderName, String cardNumber, String expDate, String cvv) {
        this.user_id = user_id;
        this.cs_id = cs_id;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public Booking() {
    }
}
