package net.mfkrg.examplemod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class CaveDetector extends Item {

    public CaveDetector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundCave = false;

            int i;
            for(i = 0; i <= positionClicked.getY() + 64; i++){
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                if (isValuableBlock(blockBelow)){
                    outputValuableCoordinates(positionClicked.down(i), player, blockBelow);
                    foundCave = true;
                    break;
                }
            }

            if (!foundCave){
                player.sendMessage(new TranslatableText("item.examplemod.CaveDetecor.no_valuables"), false);
            }

        }

        context.getStack().damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(player.getActiveHand()));


        return super.useOnBlock(context);
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow){
        player.sendMessage(new LiteralText("Found cave at ( "+ blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + " )"), false);
    }

    private boolean isValuableBlock(Block block){
        return block == Blocks.CAVE_AIR || block == Blocks.AIR;
    }

}
