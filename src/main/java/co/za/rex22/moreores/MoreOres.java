package co.za.rex22.moreores;

import co.za.rex22.moreores.common.blocks.Blocks;
import co.za.rex22.moreores.common.items.ItemTitaniumIngot;
import co.za.rex22.moreores.common.items.ToolItems;
import co.za.rex22.moreores.common.proxy.ClientProxy;
import co.za.rex22.moreores.common.proxy.IProxy;
import co.za.rex22.moreores.common.proxy.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.za.rex22.moreores.common.items.ModItems.*;

@Mod("moreores")
public class MoreOres {

    private static final Logger LOGGER = LogManager.getLogger();

    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public MoreOres() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(this::client));

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.init();
    }

    private void client(final FMLClientSetupEvent event) {
        event.getMinecraftSupplier().get().getItemColors().register(TITANIUM_INGOT, TITANIUM_INGOT);

        ToolItems.registerColorTint(event);
        Blocks.registerColorTint(event);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            Blocks.registerBlock(event);
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
            ToolItems.registerItem(event);
            Blocks.registerItemBlock(event);

            event.getRegistry().register(new ItemTitaniumIngot());
        }
    }
}
