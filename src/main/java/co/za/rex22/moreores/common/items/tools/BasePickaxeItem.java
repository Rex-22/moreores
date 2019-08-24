package co.za.rex22.moreores.common.items.tools;

import co.za.rex22.moreores.common.utils.Colors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class BasePickaxeItem extends BaseItemTool {

    public BasePickaxeItem(float attackDamageIn,
                            float attackSpeedIn,
                            IItemTier tier,
                            Set<Block> effectiveBlocks,
                            Properties properties,
                            Colors color) {
        super(attackDamageIn, attackSpeedIn, tier, effectiveBlocks, properties, color);
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(BlockState blockIn) {
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
            return i >= blockIn.getHarvestLevel();
        }
        Material material = blockIn.getMaterial();
        return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
    }

    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return ((material != Material.IRON) &&
                (material != Material.ANVIL) &&
                (material != Material.ROCK)) ?
                super.getDestroySpeed(stack, state) : this.efficiency;
    }

}
