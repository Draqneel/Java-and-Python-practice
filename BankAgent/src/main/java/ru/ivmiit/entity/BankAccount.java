package ru.ivmiit.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "currency")
    private double currency;

    @Column(name = "amount")
    private double amount;

    @Column(name = "amount_of_credit")
    private double amountOfCredit;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public BankAccount() {
    }

    public BankAccount(double currency, double amount, double amountOfCredit, Client client) {
        this.currency = currency;
        this.amount = amount;
        this.amountOfCredit = amountOfCredit;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountOfCredit() {
        return amountOfCredit;
    }

    public void setAmountOfCredit(double amountOfCredit) {
        this.amountOfCredit = amountOfCredit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
