package net.doodcraft.darkness.server;

import net.doodcraft.darkness.launcher.Launcher;
import net.doodcraft.darkness.launcher.logger.LogLevel;
import net.doodcraft.darkness.launcher.logger.Logger;
import net.doodcraft.darkness.server.connection.Connection;
import net.doodcraft.darkness.server.entity.Entity;
import net.doodcraft.darkness.server.world.World;
import net.doodcraft.darkness.server.world.WorldManager;
import net.doodcraft.darkness.server.world.tile.Tile;
import net.doodcraft.darkness.server.world.tile.TileGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Server implements Serializable {

    private Launcher launcher;
    private Logger logger;
    private WorldManager worldManager;
    private TileGenerator tileGenerator;
    private ArrayList<World> worlds;
    private ArrayList<Connection> connections;

    private final double TPS = 5.0;

    private long launch;
    private long ticks = 0;
    private boolean running = false;

    private static Server current;

    public static Server getServer() {
        return current;
    }

    public Server(Launcher launcher) {
        this.launcher = launcher;
        this.logger = launcher.getLogger();
        this.worldManager = new WorldManager(this);
        this.tileGenerator = new TileGenerator(this);
        this.worlds = new ArrayList<>();
        this.connections = new ArrayList<>();
        current = this;
    }

    public boolean isRunning() {
        return this.running;
    }

    public double tps() {
        return this.TPS;
    }

    public long getTotalTicks() {
        return this.ticks;
    }

    public void stop(int error) {

        if (error > 1 || error < 0) {
            error = 0;
        }

        this.running = false;

        for (World world : getWorlds()) {
            worldManager.saveWorld(world);
        }

        System.exit(error);
    }

    public void start() {
        running = true;

        List<World> activate = new ArrayList<>();
        activate.add(worldManager.createWorld("world"));
        for (World w : activate) {
            if (w != null) {
                addWorld(w);
            }
        }

        if (worlds.size() > 0) {
            logger.log("Active Worlds:");
            for (World w : getWorlds()) {
                int active = 0;
                for (Tile tile : w.getTiles().values()) {
                    if (tile.isLoaded()) {
                        active++;
                    }
                }
                logger.log(">> " + w.getName() + " [" + w.getTiles().size() + " generated tiles] [" + active + " active tiles]");
            }

            launch = System.currentTimeMillis();
            Thread loop = new Thread() {
                public void run() {
                    loop();
                }
            };
            loop.start();
        } else {
            logger.log("There are no valid worlds to tick; stopping server.", LogLevel.ERROR);
            stop(1);
        }
    }

    private void loop() {

        final double TIME_BETWEEN_UPDATES = 1000000000 / TPS;
        double lastUpdateTime = System.nanoTime();
        while (running) {
            double now = System.nanoTime();
            if (this.running) {
                while (now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
                    tick();
                    lastUpdateTime += TIME_BETWEEN_UPDATES;
                    ticks++;
                }

                if ( now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
                    lastUpdateTime = now - TIME_BETWEEN_UPDATES;
                }

                while (now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
                    Thread.yield();
                    try {Thread.sleep(1);} catch(Exception ignored) {}
                    now = System.nanoTime();
                }
            }
        }
    }

    public void tick() {
        for (World world : worlds) {
            world.tick();
        }
    }

    public Launcher getLauncher() {
        return this.launcher;
    }

    public String getCurrentPath() {
        return this.launcher.getCurrentPath();
    }

    public Logger getLogger() {
        return this.logger;
    }

    public WorldManager getWorldManager() {
        return this.worldManager;
    }

    public TileGenerator getTileGenerator() {
        return this.tileGenerator;
    }

    public ArrayList<World> getWorlds() {
        return worlds;
    }

    public World getWorld(String name) {
        for (World world : worlds) {
            if (world.getName().equals(name)) {
                return world;
            }
        }
        return null;
    }

    public void addWorld(World world) {
        worlds.add(world);
    }

    public void removeWorld(World world) {
        worlds.remove(world);
    }

    public ArrayList<Connection> getActiveConnections() {
        return connections;
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public void removeConnection(Connection connection) {
        connections.remove(connection);
    }

    public ArrayList<Entity> getEntities() {
        ArrayList<Entity> entities = new ArrayList<>();
        for (World world : worlds) {
            entities.addAll(world.getEntities().values());
        }
        return entities;
    }
}