package co.za.rex22.moreores.common.items;

import co.za.rex22.moreores.common.items.tools.BasePickaxeItem;
import co.za.rex22.moreores.common.items.tools.BaseShovelItem;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {

    @ObjectHolder("moreores:titanium_pickaxe")
    public static BasePickaxeItem TITANIUM_PICKAXE;

    @ObjectHolder("moreores:titanium_shovel")
    public static BaseShovelItem TITANIUM_SHOVEL;

    @ObjectHolder("moreores:titanium_ingot")
    public static ItemTitaniumIngot TITANIUM_INGOT;

    @ObjectHolder("moreores:titanium_ore")
    public static BaseBlockItem TITANIUM_ITEM_BLOCK;


}
