package net.doodcraft.darkness.server.entity;

import net.doodcraft.darkness.server.Server;
import net.doodcraft.darkness.server.exception.EntityCreateException;
import net.doodcraft.darkness.server.inventory.EntityInventory;
import net.doodcraft.darkness.server.world.Location;

public class Entity {

    public int id;
    public EntityType type;
    public Location location;
    public EntityInventory inventory;

    public Entity() throws EntityCreateException {
        if (type == null) {
            throw new EntityCreateException("EntityType cannot be null!");
        }
        this.id = Server.getServer().getEntities().size();
    }

    public int getId() {
        return this.id;
    }

    public EntityType getType() {
        return this.type;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public EntityInventory getInventory() {
        return this.inventory;
    }
}