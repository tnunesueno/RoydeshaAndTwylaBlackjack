package com.example.roydeshaandtwylablackjack;

public class ShoebQueue {

    MessageModel[] objects;

    // 0   1   2   3
    // 95  96  97
    int nextPut = 0;
    int nextGet = 0;
    int amountOfStuff = 0;
    public ShoebQueue() {

        this.objects = new MessageModel[100];

    }
    public synchronized boolean put(MessageModel obj) {
        if ( amountOfStuff> 99) {
            return false;
        }
        amountOfStuff = amountOfStuff + 1;
        // amountOfStuff increased

        objects[nextPut] = obj;
        if (nextPut>98){
            nextPut = 0;

        } else {
            nextPut = nextPut + 1;
        }
        return true;
    }

    public synchronized MessageModel get() {
        if ( amountOfStuff == 0 ) {
            return null;
        }
        amountOfStuff = amountOfStuff - 1;
        MessageModel MyData = objects[nextGet];
        if (nextGet < 99) {
            nextGet = nextGet + 1;
        } else {
            nextGet = 0;
        }
        return MyData;
    }
}