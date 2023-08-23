package github.indiasjulen.chococraft.block;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.block.custom.ChocolateRefinerBlock;
import github.indiasjulen.chococraft.item.ChocoItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ChocoBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Chococraft.MOD_ID);

    public static final RegistryObject<Block> CHOCOLATE_REFINER_BLOCK = registerBlock("chocolate_refiner",
            () -> new ChocolateRefinerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6.0f).noOcclusion()));

    public static final RegistryObject<Block> TEST = registerBlock("test",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6.0f).noOcclusion()));





    /**
     * This method returns a RegistryObject of time T, which is a generic type that extends the Block class,
     * and registers the block.
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     * Method for registering the block item itself
     */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ChocoItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
