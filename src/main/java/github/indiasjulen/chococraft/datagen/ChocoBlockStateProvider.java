package github.indiasjulen.chococraft.datagen;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.block.ChocoBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChocoBlockStateProvider extends BlockStateProvider {
    public ChocoBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Chococraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ChocoBlocks.ORANGE_TREE_LEAVES);
        blockWithItem(ChocoBlocks.ORANGE_TREE_GROWN_LEAVES);
        blockWithItem(ChocoBlocks.ORANGE_TREE_PLANKS);

        logBlock((RotatedPillarBlock) ChocoBlocks.ORANGE_TREE_LOG.get());
        axisBlock((RotatedPillarBlock) ChocoBlocks.ORANGE_TREE_WOOD.get(), blockTexture(ChocoBlocks.ORANGE_TREE_LOG.get()), blockTexture(ChocoBlocks.ORANGE_TREE_LOG.get()));
        axisBlock((RotatedPillarBlock) ChocoBlocks.STRIPPED_ORANGE_TREE_LOG.get(), new ResourceLocation(Chococraft.MOD_ID, "block/stripped_orange_tree_log"),
                new ResourceLocation(Chococraft.MOD_ID, "block/stripped_orange_tree_log_top"));
        axisBlock((RotatedPillarBlock) ChocoBlocks.STRIPPED_ORANGE_TREE_WOOD.get(), new ResourceLocation(Chococraft.MOD_ID, "block/stripped_orange_tree_log"),
                new ResourceLocation(Chococraft.MOD_ID, "block/stripped_orange_tree_log"));

        simpleBlockItem(ChocoBlocks.ORANGE_TREE_LOG.get(), models().withExistingParent("chococraft:orange_tree_log", "minecraft:block/cube_column"));
        simpleBlockItem(ChocoBlocks.ORANGE_TREE_WOOD.get(), models().withExistingParent("chococraft:orange_tree_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ChocoBlocks.STRIPPED_ORANGE_TREE_LOG.get(), models().withExistingParent("chococraft:stripped_orange_tree_log", "minecraft:block/cube_column"));
        simpleBlockItem(ChocoBlocks.STRIPPED_ORANGE_TREE_WOOD.get(), models().withExistingParent("chococraft:stripped_orange_tree_wood", "minecraft:block/cube_column"));

        saplingBlock(ChocoBlocks.ORANGE_TREE_SAPLING);
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
