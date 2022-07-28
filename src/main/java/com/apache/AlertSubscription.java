package com.apache;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Subcribtion")
@Getter
@Setter
public class AlertSubscription {
    @Id
    public String bookingNumber;
    public String currency;
    public String noOfPassengers;
    public String email;
    public String firstname;
    public String lastname;
    public String phone;
    public String language;
    public String wa;
    public String sms;
    public String airlineName;
    public String airlineCode;
    public String flightNo;
    public String originAirportCode;
    public String destAirportCode;
    public String departureTime;
    public String supportCost;
    public String supportPackage;

    public String toString(){
        return "["+bookingNumber+","+currency+","+noOfPassengers+","+email+","+firstname+","+lastname
                +","+phone+","+language+","+wa+","+sms+","+airlineName+","+airlineCode+","+flightNo
                +","+originAirportCode+","+destAirportCode+","+departureTime+","+supportCost+","+supportPackage+"]";

    }
}
