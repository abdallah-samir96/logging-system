package org.logging;

import org.logging.impl.ConsoleLogger;
import org.logging.impl.FileLogger;
import org.logging.utils.dtos.Animal;
import org.logging.utils.enums.Level;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
/*
        var logger = ConsoleLogger.getInstance(Level.ERROR);
        logger.log("abdallah");
        logger.log("ahmed");
        logger.log(12.4);
        logger.writeObject(new Animal());
*/

        Logger fileLogger = FileLogger.getInstance(Level.INFO);


    }
}