package net.doodcraft.darkness.server.world.tile.structure;

import net.doodcraft.darkness.server.inventory.StructureInventory;
import net.doodcraft.darkness.server.world.tile.Tile;

public class Structure {

    public StructureType type;
    private Tile tile;
    private StructureInventory inventory;

    public Structure(Tile tile) {
        this.tile = tile;
        this.inventory = new StructureInventory(this);
    }

    public StructureType getType() {
        return this.type;
    }

    public void setType(StructureType type) {
        // The structure type should not be changed.
        if (this.type != null) {
            this.type = type;
        }
    }

    public Tile getTile() {
        return tile;
    }

    public StructureInventory getInventory() {
        return this.inventory;
    }
}