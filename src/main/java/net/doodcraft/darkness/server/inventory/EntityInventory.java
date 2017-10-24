package net.doodcraft.darkness.server.inventory;

import net.doodcraft.darkness.server.entity.Entity;

public class EntityInventory extends Inventory {

    private Entity entity;

    public EntityInventory(Entity entity) {
        super();
        this.entity = entity;
    }

    public Entity getEntity() {
        return this.entity;
    }
}