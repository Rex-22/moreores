package co.za.rex22.moreores.common.items;

import co.za.rex22.moreores.common.group.Group;
import net.minecraft.item.Item;

public class ItemTitaniumIngot extends Item {

    public ItemTitaniumIngot() {
        super(new Item.Properties().group(Group.DEFAULT_GROUP));
        setRegistryName("titanium_ingot");
    }

}
