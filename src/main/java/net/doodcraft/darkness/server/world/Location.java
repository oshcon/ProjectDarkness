package net.doodcraft.darkness.server.world;

import net.doodcraft.darkness.server.world.tile.Tile;

public class Location {

    World world;
    int x;
    int z;

    public Location(World world, int x, int z) {
        this.world = world;
        this.x = x;
        this.z = z;
    }

    public World getWorld() {
        return world;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public Tile getTile() {
        return this.world.getTiles().get(this);
    }

    public boolean hasTile() {
        return getTile() != null;
    }
}