package org.logging.impl;

import org.logging.Logger;
import org.logging.utils.enums.Level;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @since 25-04-2023
 * @author abdallahsameer22@gmail.com
 * @version V1.0.1
 * @see ConsoleLogger
 */
public final class FileLogger implements Logger {
    private final Level level;
    private final PrintWriter printWriter;

    private final String filePath;

    private FileLogger(Level level) throws IOException {

        var fileSeparator = File.separator;
        this.filePath = "src"+ fileSeparator +"main"+ fileSeparator +"resources"+ fileSeparator +"logs"+ fileSeparator +"logging.logs";

        File file = new File(filePath);
        this.level = level;
        this.printWriter = new PrintWriter(new FileOutputStream(file, true));
    }

    public static Logger getInstance(Level level) throws IOException {
        System.out.println("**** Logging System Using FileLogger ****");
        return new FileLogger(level);
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

        try(var objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.filePath, true))) {

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
