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
                        /* FOODS */
                        pOutput.accept(ChocoItems.MILK_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.WHITE_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.DARK_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.STRAWBERRY.get());
                        pOutput.accept(ChocoItems.BLUEBERRY.get());
                        pOutput.accept(ChocoItems.RASPBERRY.get());
                        pOutput.accept(ChocoItems.ALMOND.get());
                        pOutput.accept(ChocoItems.ORANGE.get());
                        pOutput.accept(ChocoItems.ALMOND_MILK_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.RASPBERRY_MILK_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.STRAWBERRY_WHITE_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.BLUEBERRY_WHITE_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.ORANGE_DARK_CHOCOLATE_BAR.get());
                        pOutput.accept(ChocoItems.MINT_DARK_CHOCOLATE_BAR.get());

                        /* OTHER */
                        pOutput.accept(ChocoItems.MINT_LEAF.get());
                        pOutput.accept(ChocoItems.MILK_CHOCOLATE_INGOT.get());
                        pOutput.accept(ChocoItems.WHITE_CHOCOLATE_INGOT.get());
                        pOutput.accept(ChocoItems.DARK_CHOCOLATE_INGOT.get());
                        pOutput.accept(ChocoItems.ROASTED_COCOA_BEANS.get());
                        pOutput.accept(ChocoItems.COCOA_BUTTER_BOWL.get());
                        pOutput.accept(ChocoItems.MILK_BOWL.get());

                        /* ARMORS */

                        /* TOOLS */

                        /* WEAPONS */
                        //pOutput.accept(ChocoItems.WHITE_CHOCOLATE_SWORD.get());

                        // Blocks
                        pOutput.accept(ChocoBlocks.ORANGE_TREE_LOG.get());
                        pOutput.accept(ChocoBlocks.ORANGE_TREE_WOOD.get());
                        pOutput.accept(ChocoBlocks.STRIPPED_ORANGE_TREE_LOG.get());
                        pOutput.accept(ChocoBlocks.STRIPPED_ORANGE_TREE_WOOD.get());
                        pOutput.accept(ChocoBlocks.ORANGE_TREE_PLANKS.get());
                        pOutput.accept(ChocoBlocks.ORANGE_TREE_LEAVES.get());
                        pOutput.accept(ChocoBlocks.ORANGE_TREE_SAPLING.get());
                        pOutput.accept(ChocoBlocks.ORANGE_TREE_GROWN_LEAVES.get());

                        /* ENTITIES */
                        pOutput.accept(ChocoBlocks.CHOCOLATE_REFINER_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
