package org.example;

import java.io.IOException;

public class BULB extends  HouseU {
    @Override
    public void on() throws IOException {
        send("LED ON");
    }
    public void off() throws IOException {
        send("LED OFF");
    }
    public void auto() throws IOException {
        send("LED AUTO");
    }
}
