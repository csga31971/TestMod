package xyz.csga.testmod.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Entity300 extends EntityThrowable{

    private static Entity300 entity300;

    public Entity300(World world) {
        super(world);
    }

    public static Entity300 instance(World world) {
        if(entity300 == null)
            entity300 = new Entity300(world);
        return entity300;
    }

    public Entity300(World world, EntityPlayer entityPlayer) {
        super(world, entityPlayer);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if(!this.worldObj.isRemote){
            this.worldObj.createExplosion(null,movingObjectPosition.blockX,movingObjectPosition.blockY,movingObjectPosition.blockZ,5f,false);
        }
        this.setDead();
    }
}
