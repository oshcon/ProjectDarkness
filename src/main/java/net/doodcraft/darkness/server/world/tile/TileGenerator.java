package net.doodcraft.darkness.server.world.tile;

import net.doodcraft.darkness.server.Server;
import net.doodcraft.darkness.server.exception.TileCreateException;
import net.doodcraft.darkness.server.world.Location;

public class TileGenerator {

    private Server server;

    public TileGenerator(Server server) {
        this.server = server;
    }

    public void generateTile(Location location, boolean load) throws TileCreateException {
        if (!location.hasTile()) {
            // TODO: Generate the TileType, Resources, and natural Structures based on area information from Google.
            Tile tile = new Tile(location, TileType.WATER);
            location.getWorld().addTile(tile);
            if (load) {
                tile.load();
            }
        }
    }

    public Server getServer() {
        return this.server;
    }
}