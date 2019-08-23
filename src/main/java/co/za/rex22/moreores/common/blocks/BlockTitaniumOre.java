package co.za.rex22.moreores.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockTitaniumOre extends Block {

    public BlockTitaniumOre() {
        super(Block.Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(3.0f, 3.0f));
        setRegistryName("titanium_ore");
    }

}
