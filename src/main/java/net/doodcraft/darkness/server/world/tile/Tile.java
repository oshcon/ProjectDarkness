package net.doodcraft.darkness.server.world.tile;

import net.doodcraft.darkness.server.exception.TileCreateException;
import net.doodcraft.darkness.server.world.Location;
import net.doodcraft.darkness.server.world.tile.structure.Structure;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class Tile {

    private TileType type;
    private Location location;
    private List<Entity> entities;
    private List<Structure> structures;
    private int ticks;

    private boolean isLoaded;

    public Tile(Location location, TileType type) throws TileCreateException {

        if (location == null) {
            throw new TileCreateException("Location cannot be null!");
        }

        if (type == null) {
            throw new TileCreateException("TileType cannot be null!");
        }

        this.type = type;
        this.location = location;
        this.entities = new ArrayList<>();
        this.structures = new ArrayList<>();

        isLoaded = false;
    }

    public void tick() {
        ticks++;
    }

    public TileType getType() {
        return this.type;
    }

    public Location getLocation() {
        return this.location;
    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        this.entities.remove(entity);
    }

    public List<Structure> getStructures() {
        return this.structures;
    }

    public void addStructure(Structure structure) {
        this.structures.add(structure);
    }

    public void removeStructure(Structure structure) {
        this.structures.remove(structure);
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void load() {
        isLoaded = true;
    }

    public void unload() {
        isLoaded = false;
    }

    public void destroy() {
        this.getLocation().getWorld().getTiles().remove(getLocation());

    }
}