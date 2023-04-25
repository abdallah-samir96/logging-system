package org.logging;

import org.logging.impl.ConsoleLogger;
import org.logging.impl.FileLogger;
import org.logging.utils.dtos.Animal;
import org.logging.utils.enums.Level;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        // using  ConsoleLogger to log on console using PrintWriter
        var consoleLogger = ConsoleLogger.getInstance(Level.ERROR);
        consoleLogger.log("Don't Call Us We will call U");
        consoleLogger.log(12.4);
        //consoleLogger.writeObject(new Animal());
        consoleLogger.close();


        // using FileLogger to log on file
        Logger fileLogger = FileLogger.getInstance(Level.DEBUG);
        fileLogger.log(100.2);
        fileLogger.log('C');
        fileLogger.log("Don't Repeat YourSelf");
        //fileLogger.writeObject(new Animal());
        fileLogger.close();

    }
}