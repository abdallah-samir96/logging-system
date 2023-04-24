package org.logging;

import org.logging.impl.ConsoleLogger;
import org.logging.utils.dtos.Animal;
import org.logging.utils.enums.Level;

public class App {
    public static void main(String[] args) {

        var logger = ConsoleLogger.getInstance(Level.ERROR);
        logger.log("abdallah");
        logger.log("ahmed");
        logger.log(12.4);
        logger.writeObject(new Animal());

    }
}