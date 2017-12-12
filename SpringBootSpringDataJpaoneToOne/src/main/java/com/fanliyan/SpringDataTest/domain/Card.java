package com.fanliyan.SpringDataTest.domain;

import javax.persistence.*;

@Entity
public class Card {

    public Card() {
    }
    /**
     * @OneToOne：一对一关联
     * mappedBy = "card"：一对一配置参考了card
     * mappedBy = "card"中的User类中的getCard()中的Care(去除get)
     * 如果User类getCard()改为getIdCard(),这里就要写成：mappedBy = "idCard"
     */
    public Card(Integer cardId, String cardNumber) {
        this.cardNumber = cardNumber;
        this.cardId = cardId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardId;

    @Column(nullable = false)
    private String cardNumber;

    @OneToOne(mappedBy = "card", fetch = FetchType.EAGER)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
