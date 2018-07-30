package com.cenkay.staj.rest.employee;

public class EmployeeDTO {
	
    private String username;
    private String password;
    private String citizenNumber;

    public EmployeeDTO(String username, String password, String citizenNumber) {
        this.username = username;
        this.password = password;
        this.citizenNumber = citizenNumber;
    }

    public EmployeeDTO() {
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

    public String getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

}
