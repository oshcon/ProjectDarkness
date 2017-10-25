package net.doodcraft.darkness.server.world;

import net.doodcraft.darkness.server.world.tile.Tile;

public class Location {

    private World world;
    private double preciseX;
    private double preciseZ;

    public Location(World world, double preciseX, double preciseZ) {
        this.world = world;
        this.preciseX = preciseX;
        this.preciseZ = preciseZ;
    }

    public World getWorld() {
        return this.world;
    }

    public double getPreciseX() {
        return this.preciseX;
    }

    public double getPreciseZ() {
        return this.preciseZ;
    }

    public Tile getTile() {
        return this.world.getTiles().get(this);
    }

    public boolean hasTile() {
        return this.getTile() != null;
    }
}