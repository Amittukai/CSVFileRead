package com.apache;

import com.apache.repo.AlertSubscribtionRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ApacheController{

    @Autowired
    AlertSubscribtionRepo alertSubscribtionRepo ;

    @PostMapping()
    public void Read(){

        List<AlertSubscription> alertSubscribtionslist = new ArrayList<>();
        try(
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Amit\\Desktop\\airdata.csv"));
                CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br);
        ) {
            for(CSVRecord csvRecord : parser) {
                // Accessing Values by Column Index
                AlertSubscription alertSubscription = new AlertSubscription();
                String bookingNumber = csvRecord.get(0);
                alertSubscription.setBookingNumber(bookingNumber);
                String currency = csvRecord.get(1);
                alertSubscription.setCurrency(currency);
                String noOfPassengers = csvRecord.get(2);
                alertSubscription.setNoOfPassengers(noOfPassengers);
                String email = csvRecord.get(3);
                alertSubscription.setEmail(email);
                String firstname = csvRecord.get(4);
                alertSubscription.setFirstname(firstname);
                String lastname = csvRecord.get(5);
                alertSubscription.setLastname(lastname);
                String phone = csvRecord.get(6);
                alertSubscription.setPhone(phone);
                String language = csvRecord.get(7);
                alertSubscription.setLanguage(language);
                String wa = csvRecord.get(8);
                alertSubscription.setWa(wa);
                String sms = csvRecord.get(9);
                alertSubscription.setSms(sms);
                String airlineName = csvRecord.get(10);
                alertSubscription.setAirlineName(airlineName);
                String airlineCode = csvRecord.get(11);
                alertSubscription.setAirlineCode(airlineCode);
                String flightno = csvRecord.get(12);
                alertSubscription.setFlightNo(flightno);
                String originAirportCode = csvRecord.get(13);
                alertSubscription.setOriginAirportCode(originAirportCode);
                String destAirportCode = csvRecord.get(14);
                alertSubscription.setDestAirportCode(destAirportCode);
                String departuretime = csvRecord.get(15);
                alertSubscription.setDepartureTime(departuretime);
                String supportCost = csvRecord.get(16);
                alertSubscription.setSupportCost(supportCost);
                String supportPackage = csvRecord.get(17);
                alertSubscription.setSupportPackage(supportPackage);
                alertSubscribtionslist.add(alertSubscription);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(alertSubscribtionslist);
        alertSubscribtionRepo.saveAll(alertSubscribtionslist);
    }
}
