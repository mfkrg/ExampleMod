package net.mfkrg.examplemod.fluids;

import net.mfkrg.examplemod.item.ModItems;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AlloyFluid extends FlowableFluid {

    public Fluid getFlowing(){
        return ModFluids.ALLOY_FLUID;
    }

    public Fluid getStill(){
        return ModFluids.ALLOY_STILL;
    }

    public Item getBucketItem(){
        return ModItems.ALLOY_LADLE;
    }

    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random){
        if (!state.isStill() && !(Boolean)state.get(FALLING)){
            if (random.nextInt(64) == 0){
                world.playSound ((double)pos.getX() + 0.5D,
                        (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D,
                        SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS,
                        random.nextFloat()*0.25F + 0.75F, random.nextFloat() + 0.5F,
                        false);
            }
        } else if (random.nextInt(10) == 0){
            world.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(),
                    (double)pos.getY() + random.nextDouble(),
                    (double)pos.getZ() + random.nextDouble(),
                    0.0D, 0.0D, 0.0D);
        }
    }

    @Nullable
    protected ParticleEffect getParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    protected boolean isInfinite(){
        return false;
    }
}
