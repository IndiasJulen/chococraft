package github.indiasjulen.chocomod.item;

import github.indiasjulen.chocomod.Chocomod;
import github.indiasjulen.chocomod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Chocomod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHOCOMOD_TAB = CREATIVE_MODE_TABS.register("chocomod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MILK_CHOCOLATE_INGOT.get()))
                    .title(Component.translatable("creativetab.chocomod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Items
                        pOutput.accept(ModItems.MILK_CHOCOLATE_INGOT.get());
                        pOutput.accept(ModItems.WHITE_CHOCOLATE_INGOT.get());
                        pOutput.accept(ModItems.DARK_CHOCOLATE_INGOT.get());
                        pOutput.accept(ModItems.ROASTED_COCOA_BEANS.get());

                        // Blocks
                        pOutput.accept(ModBlocks.CHOCOLATE_REFINER_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
