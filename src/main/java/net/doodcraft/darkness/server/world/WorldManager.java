package net.doodcraft.darkness.server.world;

import net.doodcraft.darkness.launcher.logger.LogLevel;
import net.doodcraft.darkness.server.Server;

import java.io.File;

public class WorldManager {

    private Server server;

    public WorldManager(Server server) {
        this.server = server;
    }

    public World createWorld(String name) {

        if (worldExists(name)) {
            server.getLogger().log("Loading '" + name + "'...");
            World world = loadWorld(name);
            if (world != null) {
                server.getLogger().log("Finished loading '" + name + "'!");
                return world;
            }
            server.getLogger().log("Could not load '" + name + "'!");
            return null;
        }

        server.getLogger().log("Creating '" + name + "'...");
        World world = new World(name);
        if (!saveWorld(world)) {
            return null;
        }

        server.getLogger().log("Finished creating '" + name + "'!");
        return world;
    }

    public World loadWorld(String name) {
        File file = new File(server.getCurrentPath() + File.separator + "worlds" + File.separator + name + ".world");
        // TODO: Deserialize the world from the file
        return null;
    }

    public boolean saveWorld(World world) {
        File file = new File(server.getCurrentPath() + File.separator + "worlds" + File.separator + world.getName() + ".world");
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.getParentFile().mkdirs();
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (Exception ex) {
                server.getLogger().log("Failed to save '" + world.getName() + "'.", LogLevel.ERROR);
                ex.printStackTrace();
                return false;
            }
        }

        // TODO: Serialize the world and save it to file
        return true;
    }

    public boolean worldExists(String name) {
        File file = new File(server.getCurrentPath() + File.separator + "worlds" + File.separator + name + ".world");
        return file.exists();
    }

    public Server getServer() {
        return this.server;
    }
}