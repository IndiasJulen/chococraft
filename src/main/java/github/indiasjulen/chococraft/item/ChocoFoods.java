package github.indiasjulen.chococraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ChocoFoods {
    public static final FoodProperties MILK_CHOCOLATE_BAR = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f).build(); // we could add the .effect() method in the case of the flavoured chocolate bars

    public static final FoodProperties WHITE_CHOCOLATE_BAR = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f).build();

    public static final FoodProperties DARK_CHOCOLATE_BAR = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f).build();

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.3f).build();

    public static final FoodProperties BLUEBERRY = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.3f).build();

    public static final FoodProperties RASPBERRY = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.3f).build();

    public static final FoodProperties ORANGE = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.3f).build();

    public static final FoodProperties ALMOND = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.6f).build();

}
