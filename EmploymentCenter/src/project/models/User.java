package project.models;

import java.sql.Date;

public class User {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String city;
    private Date birthDate;
    private Date registrationDate;
    private String phoneNumber;
    private String login;
    private String hashpassword;
    private String data;
    private Role role;

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {

        this.role = role;
    }

    public User(long id, String name, String surname, String patronymic, String city, Date birthDate,
                Date registrationDate, String phoneNumber, String login, String hashpassword, String data) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.city = city;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.hashpassword = hashpassword;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", city='" + city + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", login='" + login + '\'' +
                ", hashpassword='" + hashpassword + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String toStringForFile() {
        return  id + " " +
                name + ' ' +
                surname + ' ' +
                patronymic + ' ' +
                city + ' ' +
                birthDate + ' ' +
                registrationDate + ' ' +
                phoneNumber + ' ' +
                login + ' ' +
                hashpassword + ' ' +
                data
                ;

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashpassword() {
        return hashpassword;
    }

    public void setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;
    }

}


