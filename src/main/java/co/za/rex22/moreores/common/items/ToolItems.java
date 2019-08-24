package co.za.rex22.moreores.common.items;

import co.za.rex22.moreores.common.items.tools.BaseItemTool;
import co.za.rex22.moreores.common.items.tools.BasePickaxeItem;
import co.za.rex22.moreores.common.items.tools.BaseShovelItem;
import co.za.rex22.moreores.common.utils.Colors;
import co.za.rex22.moreores.common.utils.MiniralType;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public enum ToolItems {
    TITANIUM_PICKAXE(MiniralType.TITANIUM, Type.PICKAXE, 1, -2.8f),
    TITANIUM_SHOVEL(MiniralType.TITANIUM, Type.SHOVEL, 1.5f, -3.0f),
    ;

    private MiniralType miniralType;
    private BaseItemTool instance;
    private Type toolType;

    ToolItems(MiniralType miniralType, Type toolType, float attackDamage, float attackSpeed) {
        this.miniralType = miniralType;
        this.toolType = toolType;

        try {
            instance = toolType.getItemClass().getConstructor(
                    float.class,
                    float.class,
                    IItemTier.class,
                    Set.class,
                    Item.Properties.class,
                    Colors.class)
                    .newInstance(
                            attackDamage,
                            attackSpeed,
                            miniralType.getToolProperties().getTier(),
                            toolType.getEffectiveOn(),
                            miniralType.getToolProperties().getItemProperties(),
                            miniralType.getColor());

            instance.setRegistryName(String.format("%s_%s", miniralType.getName(), toolType.getName()));

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public MiniralType getMiniralType() {
        return miniralType;
    }

    public Type getToolType() {
        return toolType;
    }

    public BaseItemTool getInstance() {
        return instance;
    }

    public static void registerItem(RegistryEvent.Register<Item> event) {
        for (ToolItems i : ToolItems.values()) {
            event.getRegistry().register(i.instance);
        }
    }

    public static void registerColorTint(FMLClientSetupEvent event) {
        for (ToolItems i : ToolItems.values()) {
            event.getMinecraftSupplier().get().getItemColors().register(i.instance, i.instance);
        }
    }

    private enum Type {
        PICKAXE("pickaxe", BaseItemTool.PICKAXE_EFFECTIVE_ON, BasePickaxeItem.class),
        SHOVEL("shovel", BaseItemTool.SHOVEL_EFFECTIVE_ON, BaseShovelItem.class),
        ;

        private String name;
        private Set<Block> effectiveOn;
        private Class<? extends BaseItemTool> itemClass;

        Type(String name, Set<Block> effectiveOn, Class<? extends BaseItemTool> itemClass) {
            this.name = name;
            this.effectiveOn = effectiveOn;
            this.itemClass = itemClass;
        }

        public Set<Block> getEffectiveOn() {
            return effectiveOn;
        }

        public String getName() {
            return name;
        }

        public Class<? extends BaseItemTool> getItemClass() {
            return itemClass;
        }
    }
}
