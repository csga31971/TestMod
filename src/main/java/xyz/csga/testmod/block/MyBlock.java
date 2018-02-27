package xyz.csga.testmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.csga.testmod.TestMod;
import xyz.csga.testmod.entity.Entity300;
import xyz.csga.testmod.item.Item300;

public class MyBlock extends Block {
    private static MyBlock myBlock;
    protected MyBlock(Material material) {
        super(material);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName("myblock");
        setBlockTextureName(TestMod.MODID + ":osu");
        setHarvestLevel("pickaxe",3);
        setHardness(3f);
    }

    public static MyBlock instance(){
        if(myBlock == null)
            myBlock = new MyBlock(Material.sand);
        return myBlock;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
        //world.createExplosion(null,x,y,z,2.0f,true);
        //dropXpOnBlockBreak(world,x,y,z,100);
        dropBlockAsItemWithChance(world,x,y,z,meta,0f,0);
        if(world.rand.nextFloat() <= 0.1){
            world.createExplosion(null,x,y,z,1.0f,true);
        }
        if(world.rand.nextFloat() <= 0.05){
            this.dropBlockAsItemWithChance(world,x,y,z,meta,0,0);//metadata, fortune
            this.dropBlockAsItem(world,x,y,z,new ItemStack(Item300.instance(),1));
        }
    }

}
