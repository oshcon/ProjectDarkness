package net.doodcraft.darkness.server.world.tile.structure.home;

import net.doodcraft.darkness.server.world.tile.Tile;
import net.doodcraft.darkness.server.world.tile.structure.Structure;
import net.doodcraft.darkness.server.world.tile.structure.StructureType;

public class Home extends Structure {

    public Home(Tile tile) {
        super(tile);
        this.type = StructureType.HOME;
    }
}