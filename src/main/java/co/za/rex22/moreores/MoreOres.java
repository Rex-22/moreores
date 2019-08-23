package co.za.rex22.moreores;

import co.za.rex22.moreores.common.blocks.BlockTitaniumOre;
import co.za.rex22.moreores.common.blocks.ModBlocks;
import co.za.rex22.moreores.common.group.Group;
import co.za.rex22.moreores.common.items.ItemTitaniumIngot;
import co.za.rex22.moreores.common.proxy.ClientProxy;
import co.za.rex22.moreores.common.proxy.IProxy;
import co.za.rex22.moreores.common.proxy.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("moreores")
public class MoreOres {

    private static final Logger LOGGER = LogManager.getLogger();

    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public MoreOres() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new BlockTitaniumOre());
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties().group(Group.DEFAULT_GROUP);
            event.getRegistry().register(new BlockItem(ModBlocks.TITANIUM_ORE, properties).setRegistryName("titanium_ore"));
            event.getRegistry().register(new ItemTitaniumIngot());
        }
    }
}
