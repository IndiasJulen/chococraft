package github.indiasjulen.chococraft.datagen;

import github.indiasjulen.chococraft.item.ChocoItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ChocoRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ChocoRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // SMELTING RECIPES
        oreSmelting(consumer, List.of(Items.COCOA_BEANS), RecipeCategory.MISC, ChocoItems.ROASTED_COCOA_BEANS.get(),
                0.7f, 200, "roasted_cocoa_beans");

        // BLASTING RECIPES
        oreBlasting(consumer, List.of(Items.COCOA_BEANS), RecipeCategory.MISC, ChocoItems.ROASTED_COCOA_BEANS.get(),
                0.7f, 100, "roasted_cocoa_beans");

        // SHAPED RECIPES
        /* milk chocolate bar */
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ChocoItems.MILK_CHOCOLATE_BAR.get())
                .define('I', ChocoItems.MILK_CHOCOLATE_INGOT.get())
                .pattern("III")
                .unlockedBy("has_milk_chocolate_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.MILK_CHOCOLATE_INGOT.get()).build()))
                .save(consumer);

        /* white chocolate bar */
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ChocoItems.WHITE_CHOCOLATE_BAR.get())
                .define('I', ChocoItems.WHITE_CHOCOLATE_INGOT.get())
                .pattern("III")
                .unlockedBy("has_white_chocolate_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.WHITE_CHOCOLATE_INGOT.get()).build()))
                .save(consumer);

        /* dark chocolate bar */
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ChocoItems.DARK_CHOCOLATE_BAR.get())
                .define('I', ChocoItems.DARK_CHOCOLATE_INGOT.get())
                .pattern("III")
                .unlockedBy("has_dark_chocolate_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.DARK_CHOCOLATE_INGOT.get()).build()))
                .save(consumer);

        // SHAPELESS RECIPES
        /* almond milk chocolate bar */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ChocoItems.ALMOND_MILK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.MILK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.ALMOND.get())
                .unlockedBy("has_milk_chocolate_bar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.MILK_CHOCOLATE_BAR.get()).build()))
                .unlockedBy("has_almond", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.ALMOND.get()).build()))
                .save(consumer);

        /* raspberry milk chocolate bar */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ChocoItems.RASPBERRY_MILK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.MILK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.RASPBERRY.get())
                .unlockedBy("has_milk_chocolate_bar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.MILK_CHOCOLATE_BAR.get()).build()))
                .unlockedBy("has_raspberry", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.RASPBERRY.get()).build()))
                .save(consumer);

        /* raspberry milk chocolate bar */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ChocoItems.RASPBERRY_MILK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.MILK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.RASPBERRY.get())
                .unlockedBy("has_milk_chocolate_bar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.MILK_CHOCOLATE_BAR.get()).build()))
                .unlockedBy("has_raspberry", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.RASPBERRY.get()).build()))
                .save(consumer);

        /* strawberry white chocolate bar */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ChocoItems.STRAWBERRY_WHITE_CHOCOLATE_BAR.get())
                .requires(ChocoItems.WHITE_CHOCOLATE_BAR.get())
                .requires(ChocoItems.STRAWBERRY.get())
                .unlockedBy("has_white_chocolate_bar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.WHITE_CHOCOLATE_BAR.get()).build()))
                .unlockedBy("has_strawberry", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.STRAWBERRY.get()).build()))
                .save(consumer);

        /* blueberry white chocolate bar */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ChocoItems.BLUEBERRY_WHITE_CHOCOLATE_BAR.get())
                .requires(ChocoItems.WHITE_CHOCOLATE_BAR.get())
                .requires(ChocoItems.BLUEBERRY.get())
                .unlockedBy("has_white_chocolate_bar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.WHITE_CHOCOLATE_BAR.get()).build()))
                .unlockedBy("has_blueberry", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.BLUEBERRY.get()).build()))
                .save(consumer);

        /* orange dark chocolate bar */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ChocoItems.ORANGE_DARK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.DARK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.ORANGE.get())
                .unlockedBy("has_dark_chocolate_bar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.DARK_CHOCOLATE_BAR.get()).build()))
                .unlockedBy("has_orange", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.ORANGE.get()).build()))
                .save(consumer);

        /* mint dark chocolate bar */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ChocoItems.MINT_DARK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.DARK_CHOCOLATE_BAR.get())
                .requires(ChocoItems.MINT_LEAF.get())
                .unlockedBy("has_dark_chocolate_bar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.DARK_CHOCOLATE_BAR.get()).build()))
                .unlockedBy("has_mint_leaf", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ChocoItems.MINT_LEAF.get()).build()))
                .save(consumer);
    }
}
