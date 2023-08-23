package github.indiasjulen.chococraft.item;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.block.ChocoBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ChocoCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Chococraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHOCOMOD_TAB = CREATIVE_MODE_TABS.register("chococraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ChocoItems.MILK_CHOCOLATE_INGOT.get()))
                    .title(Component.translatable("creativetab.chococraft_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Items
                        /* CHOCOLATE BARS */
                        pOutput.accept(ChocoItems.MILK_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.WHITE_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.DARK_CHOCOLATE_BAR.get());

                        /* INGOTS */
                        pOutput.accept(ChocoItems.MILK_CHOCOLATE_INGOT.get());
                        pOutput.accept(ChocoItems.WHITE_CHOCOLATE_INGOT.get());
                        pOutput.accept(ChocoItems.DARK_CHOCOLATE_INGOT.get());

                        /* OTHER */
                        pOutput.accept(ChocoItems.ROASTED_COCOA_BEANS.get());
                        pOutput.accept(ChocoItems.WHITE_CHOCOLATE_SWORD.get());
                        pOutput.accept(ChocoItems.COCOA_BUTTER_BOWL.get());
                        
                        // Blocks
                        pOutput.accept(ChocoBlocks.CHOCOLATE_REFINER_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}