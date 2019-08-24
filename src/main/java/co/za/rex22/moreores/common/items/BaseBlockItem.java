package co.za.rex22.moreores.common.items;

import co.za.rex22.moreores.common.utils.Colors;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

import java.util.Objects;

public class BaseBlockItem extends BlockItem implements IItemColor {

    private Colors color;

    public BaseBlockItem(Block block, Properties properties, Colors color) {
        super(block, properties);
        this.color = color;
        setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }

    @Override
    public int getColor(ItemStack itemStack, int tintIndex) {
        return color.getColor();
    }

    public Colors getColor() {
        return color;
    }
}
