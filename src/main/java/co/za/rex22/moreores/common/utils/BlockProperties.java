package co.za.rex22.moreores.common.utils;

import co.za.rex22.moreores.common.group.Group;
import co.za.rex22.moreores.common.items.BaseBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public enum BlockProperties {
    TITANIUM(Material.ROCK, SoundType.STONE, 3.0f, 3.0f);

    private Material material;
    private SoundType soundType;
    private float hardness;
    private float resistance;
    private Block.Properties properties;


    BlockProperties(Material material, SoundType soundType, float hardness, float resistance) {
        this.material = material;
        this.soundType = soundType;
        this.hardness = hardness;
        this.resistance = resistance;
        this.properties = Block.Properties.create(material)
                .sound(soundType)
                .hardnessAndResistance(hardness, resistance);
    }

    public Material getMaterial() {
        return material;
    }

    public SoundType getSoundType() {
        return soundType;
    }

    public Block.Properties getProperties() {
        return properties;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }
}
