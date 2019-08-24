package co.za.rex22.moreores.common.blocks;

import co.za.rex22.moreores.common.group.Group;
import co.za.rex22.moreores.common.items.BaseBlockItem;
import co.za.rex22.moreores.common.utils.BlockProperties;
import co.za.rex22.moreores.common.utils.Colors;
import co.za.rex22.moreores.common.utils.MiniralType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.lang.reflect.InvocationTargetException;

public enum Blocks {
    TITANIUM_ORE(MiniralType.TITANIUM, BlockProperties.TITANIUM, BaseOreBlock.class, Group.DEFAULT_GROUP),
    ;

    private final MiniralType miniralType;
    private final BlockProperties blockProperties;
    private final Class<? extends BaseBlock> blockClass;
    private BaseBlock instance;
    private BaseBlockItem itemBlock;

    Blocks(MiniralType miniralType, BlockProperties blockProperties, Class<? extends BaseBlock> blockClass, ItemGroup group, float hardness, float resistance) {
        this.miniralType = miniralType;
        this.blockProperties = blockProperties;
        this.blockClass = blockClass;

        if (hardness != -1 && resistance != -1)
            blockProperties.getProperties().hardnessAndResistance(hardness, resistance);

        try {
            instance = blockClass.getConstructor(
                    Block.Properties.class,
                    Colors.class)
                    .newInstance(
                            blockProperties.getProperties(),
                            miniralType.getColor());

            instance.setRegistryName(String.format("%s_%s", miniralType.getName(), instance.getTypeName()));
            itemBlock = new BaseBlockItem(instance, new Item.Properties().group(group), miniralType.getColor());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    Blocks(MiniralType miniralType, BlockProperties blockProperties, Class<? extends BaseBlock> blockClass, ItemGroup group) {
        this(miniralType, blockProperties, blockClass, group, -1, -1);
    }

    public static void registerBlock(RegistryEvent.Register<Block> event) {
        for (Blocks i : Blocks.values()) {
            event.getRegistry().register(i.getInstance());
        }
    }

    public static void registerItemBlock(RegistryEvent.Register<Item> event) {
        for (Blocks i : Blocks.values()) {
            event.getRegistry().register(i.getItemBlock());
        }
    }

    public static void registerColorTint(FMLClientSetupEvent event) {
        for (Blocks i : Blocks.values()) {
            event.getMinecraftSupplier().get().getBlockColors().register(i.getInstance(), i.getInstance());
            event.getMinecraftSupplier().get().getItemColors().register(i.getItemBlock(), i.getItemBlock());
        }
    }

    public MiniralType getMiniralType() {
        return miniralType;
    }

    public BlockProperties getBlockProperties() {
        return blockProperties;
    }

    public Class<? extends BaseBlock> getBlockClass() {
        return blockClass;
    }

    public BaseBlock getInstance() {
        return instance;
    }

    public BaseBlockItem getItemBlock() {
        return itemBlock;
    }
}
