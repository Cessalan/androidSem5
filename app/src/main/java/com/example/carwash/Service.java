package com.example.carwash;

public class Service {


    static final double DISCOUNT=0.25;
    private int service;

    public Service(){
        this.service=10;

    }

    public void setService(int service) {
        this.service = service;
    }

    public double getTotalPrice(int washNum){


        if(washNum>=12){
       return (washNum*service)-(washNum*service*DISCOUNT);

        }else{

        return washNum*service;
        }

    }





}
