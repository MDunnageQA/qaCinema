package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingTicketsSeleniumElements {

    @FindBy(id = "fname")
    private WebElement fname;

    @FindBy(id = "sname")
    private WebElement sname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "std")
    private WebElement std;

    @FindBy(id = "dlx")
    private WebElement dlx;

    @FindBy(id = "dateSelector")
    private WebElement dateSelector;

    @FindBy(id = "timeSelector")
    private WebElement timeSelector;

    @FindBy(id = "seatPicker")
    private WebElement seatPicker;

    @FindBy(id = "seatNumbersCheck")
    private WebElement seatNumbersCheck;

    @FindBy(id = "inputOfAdults")
    private WebElement inputOfAdults;

    @FindBy(id = "inputOfChildren")
    private WebElement inputOfChildren;

    @FindBy(id = "inputOfConcession")
    private WebElement inputOfConcession;

    @FindBy(id = "totalPrice")
    private WebElement totalPrice;

    @FindBy(id = "paypal-button")
    private WebElement paypalButton;

    @FindBy(id = "submitBtn")
    private WebElement submitBtn;


    public WebElement getFname() {
        return fname;
    }

    public WebElement getSname() {
        return sname;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getStd() {
        return std;
    }

    public WebElement getDlx() {
        return dlx;
    }

    public WebElement getDateSelector() {
        return dateSelector;
    }

    public WebElement getTimeSelector() {
        return timeSelector;
    }

    public WebElement getSeatPicker() {
        return seatPicker;
    }

    public WebElement getSeatNumbersCheck() {
        return seatNumbersCheck;
    }

    public WebElement getInputOfAdults() {
        return inputOfAdults;
    }

    public WebElement getInputOfChildren() {
        return inputOfChildren;
    }

    public WebElement getInputOfConcession() {
        return inputOfConcession;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getPaypalButton() {
        return paypalButton;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }
}
