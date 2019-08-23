package co.za.rex22.moreores.common.group;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Group extends ItemGroup {

    public static ItemGroup DEFAULT_GROUP = new Group("moreores", Items.DIAMOND_PICKAXE);

    private ItemStack icon;

    private Group(String name, Item item) {
        super(name);
        icon = new ItemStack(item);
    }

    @Override
    public ItemStack createIcon() {
        return icon;
    }
}
