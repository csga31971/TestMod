package xyz.csga.testmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import xyz.csga.testmod.TestMod;
import xyz.csga.testmod.entity.Entity300;

public class EsuWand extends Item{

    private static EsuWand esuWand;
    public EsuWand(){
        super();
        setCreativeTab(CreativeTabs.tabCombat);
        setTextureName(TestMod.MODID + ":esuwand");
        setUnlocalizedName("esuwand");
    }

    public static EsuWand instance(){
        if(esuWand == null)
            esuWand = new EsuWand();
        return esuWand;
    }
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        //这段是直接复制的
        if (!world.isRemote) {
            //原作者是投掷tnt，我改成投掷300了
            //EntityTNTPrimed entity = new EntityTNTPrimed(world, entityPlayer.posX,
                    //entityPlayer.posY + entityPlayer.getEyeHeight(), entityPlayer.posZ, entityPlayer);// getEyeHeight方法是获取物体的"眼高",即头部到脚底的距离
            Entity300 entity300 = new Entity300(world, entityPlayer);
            float angle = (entityPlayer.rotationYaw / 180F) * 3.141593F; // 水平方向的角度
            float angle2 = (-entityPlayer.rotationPitch / 180F) * 3.141593F; // 垂直方向的仰角
            final float speed = 2f; // TNT飞行速度 - 抱歉我卖了个萌 <- 原作者
            entity300.motionY = speed * MathHelper.sin(angle2); // 算出三个方向上的速度,为了方便阅读我先计算的Y轴分速度
            entity300.motionX = speed * MathHelper.cos(angle2) * -MathHelper.sin(angle); // 根据仰角算出速度在XZ平面上的投影,再正交分解投影
            entity300.motionZ = speed * MathHelper.cos(angle2) * MathHelper.cos(angle);
            world.spawnEntityInWorld(entity300); // 放置实体咯
        }
        return itemStack;
    }
}
