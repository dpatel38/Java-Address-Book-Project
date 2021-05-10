package com.tts;

public class Entry {

    private String firstName;
    private String lastName;
    private String phoneNum;
    private String email;

    public Entry(String firstName, String lastName, String phoneNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "First Name: " + firstName + "\n\n" +
                "Last Name: " + lastName + "\n\n" +
                "Phone Number: " + phoneNum + "\n\n" +
                "Email: " + email + "\n";
    }

}
