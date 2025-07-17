package org.example;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.OutputStream;

public abstract  class HouseU {
    public abstract void on() throws IOException;
    public abstract void off() throws IOException;
    public abstract void auto() throws IOException;

    public static void send(String command) throws IOException {
        SerialPort serialPort = SerialPort.getCommPort("COM8"); // Update COM port if necessary
        serialPort.setBaudRate(9600);

        if (!serialPort.openPort()) {
            System.out.println("Could not open COM port");
            return;
        }
        System.out.println("Opened COM port");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (OutputStream outputStream = serialPort.getOutputStream()) {
            outputStream.write(command.getBytes());
            outputStream.flush();

        } finally {
            serialPort.closePort();
        }
    }
}
