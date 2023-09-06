package github.indiasjulen.chococraft.block;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.block.custom.ChocoFlammableRotatedPillarBlock;
import github.indiasjulen.chococraft.block.custom.ChocolateRefinerBlock;
import github.indiasjulen.chococraft.item.ChocoItems;
import github.indiasjulen.chococraft.world.feature.tree.OrangeTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ChocoBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Chococraft.MOD_ID);

    public static final RegistryObject<Block> CHOCOLATE_REFINER_BLOCK = registerBlock("chocolate_refiner",
            () -> new ChocolateRefinerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(6.0f).noOcclusion().requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> ORANGE_TREE_LOG = registerBlock("orange_tree_log",
            () -> new ChocoFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> ORANGE_TREE_WOOD = registerBlock("orange_tree_wood",
            () -> new ChocoFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_ORANGE_TREE_LOG = registerBlock("stripped_orange_tree_log",
            () -> new ChocoFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ORANGE_TREE_WOOD = registerBlock("stripped_orange_tree_wood",
            () -> new ChocoFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> ORANGE_TREE_PLANKS = registerBlock("orange_tree_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> ORANGE_TREE_LEAVES = registerBlock("orange_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> ORANGE_TREE_SAPLING = registerBlock("orange_tree_sapling",
            () -> new SaplingBlock(new OrangeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


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
