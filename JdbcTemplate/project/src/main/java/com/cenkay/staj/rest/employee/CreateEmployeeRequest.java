package com.cenkay.staj.rest.employee;

import java.io.Serializable;

public class CreateEmployeeRequest implements Serializable {

    private static final long serialVersionUID = -8959890817446499477L;

    private String citizenNumber;
    private String username;
    private String password;

    public String getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
