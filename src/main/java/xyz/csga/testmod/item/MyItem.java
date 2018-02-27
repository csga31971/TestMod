package xyz.csga.testmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import xyz.csga.testmod.TestMod;

public class MyItem extends ItemFood{
    private static MyItem myItem;
    public MyItem(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
        setCreativeTab(CreativeTabs.tabFood);
        setMaxStackSize(64);
        setTextureName(TestMod.MODID + ":osu2");
        setPotionEffect(19,9,1,0.5f);
        setUnlocalizedName("myitem");
    }

    public static MyItem instance(){
        if(myItem == null)
            myItem = new MyItem(6,1.5f,true);
        return myItem;
    }
    @Override
    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if(world.rand.nextFloat() <= 0.1)
            entityPlayer.setFire(10);
        if(world.rand.nextFloat() <= 0.1)
            entityPlayer.addPotionEffect(new PotionEffect(19,10,1,false));
        if(world.rand.nextFloat() <= 0.01){
            entityPlayer.addPotionEffect(new PotionEffect(11,30,5,false));
        }
    }
}
