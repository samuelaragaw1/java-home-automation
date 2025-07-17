package org.example;

import java.io.IOException;

public class WINDOW extends HouseU{
    @Override
    public void on() throws IOException {

        send("WIN UP");
    }
    @Override
    public void off() throws IOException {

        send("WIN DO");
    }
    @Override
    public void auto() throws IOException {

        send("WIN A");
    }
    public static void main(String[] args) throws IOException {
        //new WINDOW().auto();
        new AC().off();
    }
}
