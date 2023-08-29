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

        // check if the recipe is for the cocoa butter or for chocolate bars
//        return matchesRecipe(2, pContainer) || matchesRecipe(3, pContainer);
        return testIngredients(pContainer);
    }

    /**
     * Method for checking what recipe is being checked and if the ingredients in the refiner match the recipe
     * @param recipeSize, 2 for the cocoa butter bowl and 3 for any of the chocolate bars
     * @param pContainer, container of the chocolate refiner block entity
     * @return true or false
     */
    private boolean matchesRecipe(int recipeSize, SimpleContainer pContainer) {
        return recipeItems.size() == recipeSize && testIngredients(pContainer);
    }

    private int getItemsInContainer(SimpleContainer pContainer) {
        int count = 0;
        for(int i = 0; i < pContainer.getContainerSize()-1; i++) {
            if(pContainer.getItem(i).getItem() != Items.AIR) count++;
        }
        return count;
    }

    /**
     * Method for iterating over the recipe elements and the items in the refiner slots and checking if they match
     * @param pContainer, container of the chocolate refiner block entity
     * @return true or false
     */
    private boolean testIngredients(SimpleContainer pContainer) {
        if(getItemsInContainer(pContainer) != recipeItems.size()) return false;

        boolean matchesIngredient = false;

        for (int i = 0; i < pContainer.getContainerSize() - 1; i++) { // index for iterating the items in the refiner
            matchesIngredient = false;
            for (Ingredient recipeItem : recipeItems) {
                if (recipeItem.test(pContainer.getItem(i))) {
                    matchesIngredient = true;
                    break;
                }
            }
            if (!matchesIngredient) return false;
        }
        return matchesIngredient;
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
