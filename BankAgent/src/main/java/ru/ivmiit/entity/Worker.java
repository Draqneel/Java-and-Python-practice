package ru.ivmiit.entity;

import org.hibernate.annotations.GenericGenerator;
import ru.ivmiit.entity.enums.WorkerStatus;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private WorkerStatus status;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    public Worker() {
    }

    public Worker(String firstName, String lastName, WorkerStatus status, String phoneNumber, Bank bank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.bank = bank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public WorkerStatus getStatus() {
        return status;
    }

    public void setStatus(WorkerStatus status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

}