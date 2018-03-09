package xyz.csga.testmod.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import xyz.csga.testmod.TestMod;
import xyz.csga.testmod.mob.TestMob;

public class TestMobRenderer extends RendererLivingEntity{

    public TestMobRenderer(ModelBase modelBase, float f){
        super(modelBase, f);
    }

    public void renderTestMob(EntityLivingBase entityLivingBase, double d, double d1, double d2, float f, float f1)
    {
        super.doRender((TestMob)entityLivingBase,d,d1,d2,f,f1);
    }

    public void doRender(EntityLivingBase entityLivingBase, double d, double d1, double d2, float f, float f1){
        renderTestMob((TestMob)entityLivingBase,d,d1,d2,f,f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1){
        renderTestMob((TestMob)entity,d,d1,d2,f,f1);
    }
    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return new ResourceLocation(TestMod.MODID, "assets/testmod/textures/entity/miss.png");
    }
}
