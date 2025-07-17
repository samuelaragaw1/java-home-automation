package org.example;

import java.io.IOException;

public class AC extends HouseU{
    @Override
    public void on() throws IOException {
        send("HEAT ON");
    }
    @Override
    public void off() throws IOException {
        send("HEAT OFF");
    }
    @Override
    public void auto() throws IOException {
        double value = Temprature.displayWeatherData(9.02497, 38.74689);
        send("HEAT AUTO" + value);
    }
}
