package co.za.rex22.moreores.common.blocks;

import co.za.rex22.moreores.common.utils.Colors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.BlockRenderLayer;

public class BaseOreBlock extends BaseBlock implements IBlockColor {

    public BaseOreBlock(Properties properties, Colors color) {
        super(properties, color, "ore");
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

}
