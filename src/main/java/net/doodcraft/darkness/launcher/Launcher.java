package net.doodcraft.darkness.launcher;

import net.doodcraft.darkness.launcher.logger.Logger;
import net.doodcraft.darkness.server.Server;

import java.nio.file.Paths;

public class Launcher {

    private Logger logger;
    private String currentPath;

    public Launcher() {
        this.logger = new Logger(this);
        this.currentPath = Paths.get("").toAbsolutePath().toString();

        logger.log("----------[ PROJECT DARKNESS ]----------");
        logger.log("v1.0.0");
        logger.log("Current Directory: " + currentPath);
    }

    public void launchServer() {
        logger.log("Launching server...");
        Server server = new Server(this);
        server.start();
    }

    public void launchClient() {

    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public String getCurrentPath() {
        return this.currentPath;
    }

    // STATIC
    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.launchServer();
    }
}