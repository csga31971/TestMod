package xyz.csga.testmod;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import xyz.csga.testmod.block.MyBlock;
import xyz.csga.testmod.command.TestCommand;
import xyz.csga.testmod.entity.Entity300;
import xyz.csga.testmod.item.EsuWand;
import xyz.csga.testmod.item.Item300;
import xyz.csga.testmod.item.MyItem;
import xyz.csga.testmod.mob.TestMob;
import xyz.csga.testmod.renderer.TestMobRenderer;
import xyz.csga.testmod.server.ServerProxy;

@Mod(modid = TestMod.MODID, version = TestMod.VERSION)
public class TestMod {
    public static final String MODID = "testmod";
    public static final String VERSION = "1.0";

    public static MyBlock myBlock = MyBlock.instance();
    public static MyItem myItem = MyItem.instance();
    public static EsuWand esuWand = EsuWand.instance();
    public static Item300 item300 = Item300.instance();

    @SidedProxy(clientSide = "xyz.csga.testmod.client.ClientProxy", serverSide = "xyz.csga.testmod.server.ServerProxy")
    public static ServerProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        GameRegistry.registerBlock(myBlock, "myblock");
        GameRegistry.registerItem(myItem, "myitem");
        GameRegistry.registerItem(item300, "300");
        GameRegistry.registerItem(esuWand, "esuwand");
        EntityRegistry.registerModEntity(Entity300.class, "300",1,this,64,3,true);
        EntityRegistry.registerModEntity(TestMob.class, "gust", 2, this, 32, 3, true);
        /*RenderingRegistry.registerEntityRenderingHandler(TestMob.class, new TestMobRenderer(new ModelBase() {
            @Override
            public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
                super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
            }
        }, 1f));*/
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.addRecipe(new ItemStack(myBlock, 1), new Object[]{"## ","## ",'#', Items.ender_pearl});
        GameRegistry.addRecipe(new ItemStack(Items.gold_nugget,4), new Object[]{"###","###","###",'#', myBlock});
        GameRegistry.addRecipe(new ItemStack(esuWand,1), new Object[]{" **"," #*","#  ",'#',myBlock,'*',item300});
        GameRegistry.addSmelting(myBlock, new ItemStack(myItem,4), 1);
    }

    @Mod.EventHandler
    public void start(FMLServerStartingEvent event)
    {
        //看了下有些mod里是这样写的
        //https://github.com/MrNobody98/morecommands
        //ServerCommandManager commandManager = (ServerCommandManager)MinecraftServer.getServer().getCommandManager();
        //commandManager.registerCommand(new TestCommand());
        event.registerServerCommand(new TestCommand());
    }

}
