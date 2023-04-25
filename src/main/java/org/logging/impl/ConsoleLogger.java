package org.logging.impl;

import org.logging.Logger;
import org.logging.utils.enums.Level;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * @since 25-04-2023
 * @author abdallahsameer22@gmail.com
 * @version V1.0.1
 * @see FileLogger
 */
public final class ConsoleLogger implements Logger {
    private final Level level;
    private final PrintWriter printWriter;
    private ConsoleLogger(Level level){

        this.level = level;
        this.printWriter = new PrintWriter(System.out);
    }

    public static Logger getInstance(Level level) {
        System.out.println("**** Logging System Using ConsoleLogger ****");
        return new ConsoleLogger(level);
    }

    @Override
    public void log(String text) {

        printWriter.println(this.level + " " + this.getClass().getName() + " " + LocalDateTime.now() + " " + text);
        printWriter.flush();
    }

    @Override
    public void log(long value) {

        printWriter.println(this.level + " " + this.getClass().getName() + " " + LocalDateTime.now() + " " + value);
        printWriter.flush();
    }

    @Override
    public void log(char character) {

        printWriter.println(this.level + " " + this.getClass().getName() + " " + LocalDateTime.now() + " " + character);
        printWriter.flush();
    }

    @Override
    public void log(double value) {

        printWriter.println(this.level + " " + this.getClass().getName() + " " + LocalDateTime.now() + " " + value);
        printWriter.flush();
    }

    @Override
    public <T> void writeObject(T object) {

        try(var objectOutputStream = new ObjectOutputStream(System.out)) {

            objectOutputStream.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        this.printWriter.close();
    }

}
