package github.indiasjulen.chococraft.datagen;

import github.indiasjulen.chococraft.block.ChocoBlocks;
import github.indiasjulen.chococraft.item.ChocoItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ChocoBlockLootTables extends BlockLootSubProvider {
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    protected ChocoBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // blocks that drop themselves when breaking
        dropSelf(ChocoBlocks.CHOCOLATE_REFINER_BLOCK.get());
        dropSelf(ChocoBlocks.ORANGE_TREE_PLANKS.get());
        dropSelf(ChocoBlocks.ORANGE_TREE_WOOD.get());
        dropSelf(ChocoBlocks.ORANGE_TREE_LOG.get());
        dropSelf(ChocoBlocks.STRIPPED_ORANGE_TREE_WOOD.get());
        dropSelf(ChocoBlocks.STRIPPED_ORANGE_TREE_LOG.get());
        dropSelf(ChocoBlocks.ORANGE_TREE_SAPLING.get());

        // for ores and other special blocks dropSelf is not enough

        /* simple orange tree leaves that may drop a saplings */
        add(ChocoBlocks.ORANGE_TREE_LEAVES.get(),
                (block) -> createLeavesDrops(ChocoBlocks.ORANGE_TREE_LEAVES.get(), ChocoBlocks.ORANGE_TREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        /* orange tree leaves with grown oranges that drop saplings and oranges */
        add(ChocoBlocks.ORANGE_TREE_GROWN_LEAVES.get(),
                (block) -> createLeavesDrops(ChocoBlocks.ORANGE_TREE_GROWN_LEAVES.get(), ChocoBlocks.ORANGE_TREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES)
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(this.applyExplosionCondition(ChocoBlocks.ORANGE_TREE_LEAVES.get(), LootItem.lootTableItem(ChocoItems.ORANGE.get())))));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ChocoBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
