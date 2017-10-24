package net.doodcraft.darkness.server.inventory;

import net.doodcraft.darkness.server.world.tile.structure.Structure;

public class StructureInventory extends Inventory {

    private Structure structure;

    public StructureInventory(Structure structure) {
        super();
        this.structure = structure;
    }

    public Structure getStructure() {
        return this.structure;
    }
}