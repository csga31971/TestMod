package xyz.csga.testmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.csga.testmod.TestMod;
import xyz.csga.testmod.item.Item300;

public class MyBlock extends Block {
    private static MyBlock myBlock;
    protected MyBlock(Material material) {
        super(material);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName("myblock");
        setBlockTextureName(TestMod.MODID + ":osu");//对应的文件：/resources/assets/[标识id，一般用modid]/blocks/[冒号后面的字符串].png
        setHarvestLevel("pickaxe",3);//钻石镐
        setHardness(1f);//一开始设成了2000挖了一万年也没挖动
        setResistance(6000f);
    }

    public static MyBlock instance(){
        if(myBlock == null)
            myBlock = new MyBlock(Material.rock);
        return myBlock;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
        if(!world.isRemote) {
            if (world.rand.nextFloat() <= 0.1) {
                world.createExplosion(null, x, y, z, 1.5f, true);//参数：entity,x,y,z,strength,smoke
            }
            if (world.rand.nextFloat() <= 0.05) {
                dropBlockAsItem(world, x, y, z, new ItemStack(new Item300(), 1));
            }
        }
    }
}
