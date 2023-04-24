package org.logging;

import org.logging.utils.enums.Level;

public interface Logger {


     void log(String text);
     void log(long value);
     void log(char character);
     void log(double value);
     <T> void writeObject(T object);
}
