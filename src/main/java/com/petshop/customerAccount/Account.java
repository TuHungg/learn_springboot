package com.petshop.customerAccount;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer Id;

    @Column(name = "username")
    private String UserName;

    @Column(name = "password")
    private String PassWord;

    private String Roles;

    public Account() {
    }

    public Account(String userName, String passWord) {
        UserName = userName;
        PassWord = passWord;
    }

    public Account(String userName, String passWord, String roles) {
        UserName = userName;
        PassWord = passWord;
        Roles = roles;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String roles) {
        Roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return Objects.equals(Id, that.Id) && Objects.equals(UserName, that.UserName) && Objects.equals(PassWord, that.PassWord) && Objects.equals(Roles, that.Roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, UserName, PassWord, Roles);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "Id=" + Id +
                ", UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", Roles='" + Roles + '\'' +
                '}';
    }
}
