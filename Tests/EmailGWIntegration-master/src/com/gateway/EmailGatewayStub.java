package com.gateway;

import com.customer.Customer;

import java.util.ArrayList;

public class EmailGatewayStub implements IEmailGateway{
    static ArrayList<String> messagesSent = new ArrayList<String>();

    @Override
    public void sendSpecialGreetings(Customer customer) {
            System.out.println(customer.getName());
            messagesSent.add(customer.getName());
            //Hello Dear CostumerJohn
    }

    @Override
    public void sendRegularGreetings(Customer customer) {
            System.out.println(customer.getName());
            messagesSent.add(customer.getName());
            //Hello Mr.John
    }

    public static int getSentEmails(){
        return messagesSent.size();
    }

    public static ArrayList<String> getMessagesSent() {
        return messagesSent;
    }

}
