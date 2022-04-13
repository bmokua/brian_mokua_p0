package dev.mokua.utilities;

import jdk.jfr.internal.LogLevel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

enum logLevel{
    INFO,
    ERROR,
    WARNING,
    DEBUG

}
public class Logger {

    public static void logInfo(String message, LogLevel level){
        // log Level + message + timeStamp
        String logMessage = level.name() + "" + message + " " + new Date() + "\n";

        try {
            Files.write(Paths.get("C:\\Users\\Brian\\BankingApplication\\applogs.log"),
                    message.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}