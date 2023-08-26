package github.indiasjulen.chococraft.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import github.indiasjulen.chococraft.Chococraft;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ChocolateRefinerRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> recipeItems;

    public ChocolateRefinerRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.result = result;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer pContainer, @NotNull Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return matchesForCocoaButterBowl(pContainer) || matchesForChocolateBars(pContainer);
    }

    private boolean matchesForChocolateBars(SimpleContainer pContainer) {
        if(recipeItems.size() == 3) return testIngredientCombinationsForChocolates(pContainer);
        else return false;
    }

    private boolean testIngredientCombinationsForChocolates(SimpleContainer pContainer) {
        boolean matchesIngredient = false;
        for(int i = 0; i < recipeItems.size(); i++) { // index for iterating the recipe ingredients
            for(int j = 0; j < recipeItems.size(); j++) { // index for iterating the items in the refiner
                if (recipeItems.get(i).test(pContainer.getItem(j))) {
                    matchesIngredient = true;
                }
            }

            matchesIngredient = false;
        }
        return true;
    }


    private boolean matchesForCocoaButterBowl(SimpleContainer pContainer) {
        return recipeItems.size() == 1 && pContainer.getItem(3).getItem() == Items.BOWL
                && (recipeItems.get(0).test(pContainer.getItem(0))
                || recipeItems.get(0).test(pContainer.getItem(1))
                || recipeItems.get(0).test(pContainer.getItem(2)));
    }

    @Override
    public ItemStack assemble(@NotNull SimpleContainer pContainer, @NotNull RegistryAccess pRegistryAccess) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess pRegistryAccess) {
        return result.copy();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ChocolateRefinerRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "chocolate_refining";
    }

    public static class Serializer implements RecipeSerializer<ChocolateRefinerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Chococraft.MOD_ID, "chocolate_refining");

        /**
         * Making a recipe using a JSON file
         */
        @Override
        public @NotNull ChocolateRefinerRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new ChocolateRefinerRecipe(pRecipeId, output, inputs);
        }

        /**
         * Sending the recipe from the client to the server
         */
        @Override
        public @Nullable ChocolateRefinerRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack output = pBuffer.readItem();
            return new ChocolateRefinerRecipe(pRecipeId, output, inputs);
        }

        /**
         * Sending the recipe from the server to the client
         */
        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ChocolateRefinerRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());

            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }
            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
