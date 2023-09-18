package github.indiasjulen.chococraft.world.feature;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.Config;
import github.indiasjulen.chococraft.block.ChocoBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ChocoConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_TREE_KEY = registerKey("orange_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        register(context, ORANGE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ChocoBlocks.ORANGE_TREE_LOG.get()), // block that is going to be displayed as the trunk (tronco)
                new StraightTrunkPlacer(5, 1, 1), // min height of the tree, randomA and randomB used to give some randomness to size
                BlockStateProvider.simple(ChocoBlocks.ORANGE_TREE_LEAVES.get()), // the leaves of the tree
//                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.RED_MAPLE_LEAVES.get().defaultBlockState(), 90).add(ModBlocks.RED_MAPLE_ORANGES_LEAVES.get().defaultBlockState(), 20).build()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), // the way of placing the leaves
                new TwoLayersFeatureSize(1, 0, 2)).build() // how many trees can spawn together(?? no sé
        );

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Chococraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }



//    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE =
//            CONFIGURED_FEATURES.register("red_maple", () ->
//                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                            BlockStateProvider.simple(ChocoBlocks.ORANGE_TREE_LOG.get()), // block that is going to be displayed as the trunk (tronco)
//                            new StraightTrunkPlacer(5, 1, 1), // min height of the tree, randomA and randomB used to give some randomness to size
//                            BlockStateProvider.simple(ChocoBlocks.ORANGE_TREE_LEAVES.get()), // the leaves of the tree
////                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.RED_MAPLE_LEAVES.get().defaultBlockState(), 90).add(ModBlocks.RED_MAPLE_ORANGES_LEAVES.get().defaultBlockState(), 20).build()),
//                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), // the way of placing the leaves
//                            new TwoLayersFeatureSize(1, 0, 2)).build())); // how many trees can spawn together(?? no sé
}
