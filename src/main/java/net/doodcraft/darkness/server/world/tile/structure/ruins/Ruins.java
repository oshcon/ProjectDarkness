package net.doodcraft.darkness.server.world.tile.structure.ruins;

import net.doodcraft.darkness.server.world.tile.Tile;
import net.doodcraft.darkness.server.world.tile.structure.Structure;
import net.doodcraft.darkness.server.world.tile.structure.StructureType;

public class Ruins extends Structure {

    public Ruins(Tile tile) {
        super(tile);
        this.type = StructureType.RUINS;
    }
}