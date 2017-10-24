package net.doodcraft.darkness.server.entity;

import net.doodcraft.darkness.server.exception.EntityCreateException;

import java.util.UUID;

public class EntityOfflinePlayer extends Entity {

    private UUID uuid;
    private String name;

    public EntityOfflinePlayer(String name) throws EntityCreateException {
        super();
        this.type = EntityType.PLAYER;
        this.name = name;
        this.uuid = UUID.fromString("PLAYER:" + name);
    }
}