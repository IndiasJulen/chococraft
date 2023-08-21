package github.indiasjulen.chocomod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties MILK_CHOCOLATE_BAR = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f).build(); // we could add the .effect() method in the case of the flavoured chocolate bars

    public static final FoodProperties WHITE_CHOCOLATE_BAR = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f).build();

    public static final FoodProperties DARK_CHOCOLATE_BAR = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f).build();
}
