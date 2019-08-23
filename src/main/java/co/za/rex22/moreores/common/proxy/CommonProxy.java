package co.za.rex22.moreores.common.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CommonProxy implements IProxy {
    @Override
    public void init() {

    }

    @Override
    public World getClientWorld() {
        return null;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return null;
    }
}
