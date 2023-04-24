package org.logging.impl;

import org.logging.Logger;
import org.logging.utils.enums.Level;

import java.io.*;
import java.time.LocalDateTime;

public class FileLogger implements Logger {
    private final Level level;
    private   PrintWriter printWriter;

    private static final String name = "logging.logs";
    private FileLogger(Level level) throws IOException {

        var path = this.getClass().getClassLoader().getResource("logging.logs");
        File file = new File(path.getFile());
        if(file.exists()) System.out.println("exists");
        System.out.println(path);
        this.level = level;
       // this.printWriter = new PrintWriter(new FileOutputStream(path));
    }

    public static Logger getInstance(Level level) throws IOException {
        System.out.println("**** Logging System ****");
        return new FileLogger(level);
    }

    @Override
    public void log(String text) {

        printWriter.println(this.level + " " + this.getClass().getName() + "-" + LocalDateTime.now() + " " + text);
        printWriter.flush();
    }

    @Override
    public void log(long value) {

        printWriter.println(this.level + " " + this.getClass().getName() + "-" + LocalDateTime.now() + " " + value);
        printWriter.flush();
    }

    @Override
    public void log(char character) {

        printWriter.println(this.level + " " + this.getClass().getName() + "-" + LocalDateTime.now() + " " + character);
        printWriter.flush();
    }

    @Override
    public void log(double value) {

        printWriter.println(this.level + " " + this.getClass().getName() + "-" + LocalDateTime.now() + " " + value);
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


}
