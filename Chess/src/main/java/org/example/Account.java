package org.example;

public abstract class Account {
    String userid;
    String name;
    Address address;
    AccountStatus status;

    public void resetPassword(){}
}

class Address {
    String houseNumber;
    String block;
    String streetName;
    String city;
    int pinCode;
}

enum AccountStatus {
    ACTIVE, CLOSED, CANCELED, BLACKLISTED, NONE
}