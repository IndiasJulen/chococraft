package github.indiasjulen.chococraft;

import com.mojang.logging.LogUtils;
import github.indiasjulen.chococraft.block.ChocoBlocks;
import github.indiasjulen.chococraft.block.entity.ChocoBlockEntities;
import github.indiasjulen.chococraft.item.ChocoCreativeModeTabs;
import github.indiasjulen.chococraft.item.ChocoItems;
import github.indiasjulen.chococraft.recipe.ChocoRecipes;
import github.indiasjulen.chococraft.screen.ChocolateRefinerScreen;
import github.indiasjulen.chococraft.screen.ChocoMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Chococraft.MOD_ID)
public class Chococraft {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "chococraft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Chococraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ChocoCreativeModeTabs.register(modEventBus);

        ChocoItems.register(modEventBus);
        ChocoBlocks.register(modEventBus);

        ChocoBlockEntities.register(modEventBus);

        ChocoMenuTypes.register(modEventBus);

        ChocoRecipes.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ChocoMenuTypes.CHOCOLATE_REFINER_MENU.get(), ChocolateRefinerScreen::new);

        }
    }
}
