package net.doodcraft.darkness.server.world;

import net.doodcraft.darkness.server.Server;
import net.doodcraft.darkness.server.entity.Entity;
import net.doodcraft.darkness.server.world.tile.Tile;
import net.doodcraft.darkness.server.world.tile.TileGenerator;

import java.util.concurrent.ConcurrentHashMap;

public class World {

    private String name;
    private TileGenerator tGenerator;
    private ConcurrentHashMap<Integer, Entity> entities;
    private ConcurrentHashMap<Location, Tile> tiles;
    private long ticks = 0;
    private long created;

    public World(String name) {
        this.name = name;
        this.tGenerator = Server.getServer().getTileGenerator();
        this.entities = new ConcurrentHashMap<>();
        this.tiles = new ConcurrentHashMap<>();
        this.created = System.currentTimeMillis();
    }

    public void tick() {
        ticks++;
        for (Tile tile : tiles.values()) {
            if (tile.isLoaded()) {
                tile.tick();
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public TileGenerator getTileGenerator() {
        return this.tGenerator;
    }

    public ConcurrentHashMap<Integer, Entity> getEntities() {
        return entities;
    }

    public void spawnEntity(Entity entity, Location location) {
        addEntity(entity);
    }

    public void addEntity(Entity entity) {
        entities.put(entity.getId(), entity);
    }

    public void despawnEntity(Entity entity) {
        removeEntity(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity.getId());
    }

    public void removeEntity(int id) {
        entities.remove(id);
    }

    public ConcurrentHashMap<Location, Tile> getTiles() {
        return tiles;
    }

    public void addTile(Tile tile) {
        tiles.put(tile.getLocation(), tile);
    }

    public void removeTile(Tile tile) {
        tiles.remove(tile.getLocation());
    }

    public void removeTile(Location location) {
        tiles.remove(location);
    }
}