package co.za.rex22.moreores.common.items;

import co.za.rex22.moreores.common.group.Group;
import co.za.rex22.moreores.common.utils.Colors;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemTitaniumIngot extends Item implements IItemColor {

    public ItemTitaniumIngot() {
        super(new Item.Properties().group(Group.DEFAULT_GROUP));
        setRegistryName("titanium_ingot");
    }

    @Override
    public int getColor(ItemStack itemStack, int tintIndex) {
        return Colors.TITANIUM.getColor();
    }
}
