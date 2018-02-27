package xyz.csga.testmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.csga.testmod.TestMod;

public class Item300 extends Item{

    private static Item300 item300;
    public Item300(){
        super();
        setTextureName(TestMod.MODID + ":300");
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("300");
    }

    public static Item300 instance(){
        if(item300 == null)
            item300 = new Item300();
        return item300;
    }
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        if (!entityPlayer.capabilities.isCreativeMode)
            --itemStack.stackSize;
        world.playSoundAtEntity(entityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));//MD不知道去哪查声音文件名
        entityPlayer.addExperience(5);//加经验，作为对比烤一块牛肉给0.35经验，挖一块煤给0-2经验
        return itemStack;
    }

}
