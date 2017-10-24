package net.doodcraft.darkness.launcher.logger;

import net.doodcraft.darkness.launcher.Launcher;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    public Logger(Launcher launcher) {
        launcher.setLogger(this);
        // TODO: Save log to file.
    }

    public static SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void log(String message, LogLevel level) {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        message = String.format("[%1$s][%2$s]: %3$s", simpleDateFormat.format(timeStamp), level.toString(), message);
        System.out.println(message);
    }

    public void log(String message) {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        message = String.format("[%1$s][INFO]: %2$s", simpleDateFormat.format(timeStamp), message);
        System.out.println(message);
    }
}