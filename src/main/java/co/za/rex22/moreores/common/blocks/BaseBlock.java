package co.za.rex22.moreores.common.blocks;

import co.za.rex22.moreores.common.utils.Colors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IEnviromentBlockReader;

import javax.annotation.Nullable;

public class BaseBlock extends Block implements IBlockColor {

    private Colors color;
    private String typeName;

    public BaseBlock(Properties properties, Colors color, String typeName) {
        super(properties);
        this.color = color;
        this.typeName = typeName;
    }

    public BaseBlock(Properties properties, Colors color) {
        this(properties, color, "block");
    }

    @Override
    public int getColor(
            BlockState blockState,
            @Nullable IEnviromentBlockReader iEnviromentBlockReader,
            @Nullable BlockPos blockPos,
            int tintIndex) {
        return  tintIndex == 1 ? color.getColor() : Colors.NONE.getColor();
    }

    public Colors getColor() {
        return color;
    }

    public String getTypeName() {
        return typeName;
    }
}
