package github.indiasjulen.chococraft.datagen;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.block.ChocoBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ChocoBlockStateProvider extends BlockStateProvider {
    public ChocoBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Chococraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ChocoBlocks.ORANGE_TREE_LOG);
        blockWithItem(ChocoBlocks.ORANGE_TREE_WOOD);
        blockWithItem(ChocoBlocks.ORANGE_TREE_LEAVES);
        blockWithItem(ChocoBlocks.ORANGE_TREE_SAPLING);
        blockWithItem(ChocoBlocks.ORANGE_TREE_PLANKS);
        //blockWithItem(ChocoBlocks.STRIPPED_ORANGE_TREE_LOG);
        blockWithItem(ChocoBlocks.STRIPPED_ORANGE_TREE_WOOD);
    }

    protected void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

//    protected void logBlockWithItem(RegistryObject<Block> blockRegistryObject) {
//        simpleBlockItem(blockRegistryObject.get(), );
//        logBlock(((RotatedPillarBlock) blockRegistryObject.get()));
//    }

}
