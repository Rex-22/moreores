package co.za.rex22.moreores.common.items.tools;

import co.za.rex22.moreores.common.utils.Colors;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Set;

public class BaseShovelItem extends BaseItemTool {

    protected static final Map<Block, BlockState> BLOCK_CONVERSION = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));

    public BaseShovelItem(float attackDamageIn,
                          float attackSpeedIn,
                          IItemTier tier,
                          Set<Block> effectiveOn,
                          Item.Properties builder,
                          Colors color) {
        super(attackDamageIn, attackSpeedIn, tier, effectiveOn, builder.addToolType(net.minecraftforge.common.ToolType.SHOVEL, tier.getHarvestLevel()), color);
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(BlockState blockIn) {
        Block block = blockIn.getBlock();
        return block == Blocks.SNOW || block == Blocks.SNOW_BLOCK;
    }

    /**
     * Called when this item is used when targetting a Block
     */
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        if (context.getFace() == Direction.DOWN && !world.getBlockState(blockpos.up()).isAir(world, blockpos.up())) {
            return ActionResultType.PASS;
        }

        BlockState blockstate = BLOCK_CONVERSION.get(world.getBlockState(blockpos).getBlock());
        if (blockstate == null) {
            return ActionResultType.PASS;
        }

        PlayerEntity playerentity = context.getPlayer();
        world.playSound(playerentity, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (!world.isRemote) {
            world.setBlockState(blockpos, blockstate, 11);
            if (playerentity != null) {
                context.getItem().damageItem(1, playerentity, (item) -> item.sendBreakAnimation(context.getHand()));
            }
        }

        return ActionResultType.SUCCESS;

    }
}
