package co.za.rex22.moreores.common.utils;

import co.za.rex22.moreores.common.group.Group;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;

public enum ToolProperties {
    TITANIUM(ItemTier.DIAMOND, new Item.Properties().group(Group.DEFAULT_GROUP));

    private final ItemTier tier;
    private final Item.Properties itemProperties;

    ToolProperties(ItemTier tier, Item.Properties itemProperties) {

        this.tier = tier;
        this.itemProperties = itemProperties;
    }

    public ItemTier getTier() {
        return tier;
    }

    public Item.Properties getItemProperties() {
        return itemProperties;
    }
}
