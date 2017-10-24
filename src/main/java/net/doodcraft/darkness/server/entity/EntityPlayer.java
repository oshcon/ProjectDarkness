package net.doodcraft.darkness.server.entity;

import net.doodcraft.darkness.server.exception.EntityCreateException;

public class EntityPlayer extends EntityOfflinePlayer {

    public EntityPlayer(String name) throws EntityCreateException {
        super(name);
    }
}