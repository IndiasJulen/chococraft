package github.indiasjulen.chococraft.world.feature;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.block.ChocoBlocks;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class ChocoConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(ResourceKey.createRegistryKey(new ResourceLocation("worldgen/configured_feature")), Chococraft.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE =
            CONFIGURED_FEATURES.register("red_maple", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ChocoBlocks.ORANGE_TREE_LOG.get()), // block that is going to be displayed as the trunk (tronco)
                            new StraightTrunkPlacer(5, 1, 1), // min height of the tree, randomA and randomB used to give some randomness to size
                            BlockStateProvider.simple(ChocoBlocks.ORANGE_TREE_LEAVES.get()), // the leaves of the tree
//                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.RED_MAPLE_LEAVES.get().defaultBlockState(), 90).add(ModBlocks.RED_MAPLE_ORANGES_LEAVES.get().defaultBlockState(), 20).build()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), // the way of placing the leaves
                            new TwoLayersFeatureSize(1, 0, 2)).build())); // how many trees can spawn together(?? no sé
}