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
    private int x;
    private int z;
    private Long ticks;

    private boolean isLoaded;

    public Tile(Location location, TileType type) throws TileCreateException {
        if (type == null) {
            throw new TileCreateException("TileType cannot be null!");
        }
        if (location == null) {
            throw new TileCreateException("Location cannot be null!");
        }

        this.type = type;
        this.location = location;
        this.entities = new ArrayList<>();
        this.structures = new ArrayList<>();

        // TODO: Calculate x and z based on precise location from Google.
        this.ticks = 0L;

        // TODO: Start a task to determine whether to unload a tile automatically after a set duration of player inactivity.
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

    public Long getTime() {
        // TODO: Return real world time based on tile's precise location.
        return System.currentTimeMillis();
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