package github.indiasjulen.chococraft.item;

import github.indiasjulen.chococraft.Chococraft;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChocoItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Chococraft.MOD_ID);

    /* FOOD */
    public static final RegistryObject<Item> MILK_CHOCOLATE_BAR = ITEMS.register("milk_chocolate_bar",
            () -> new Item(new Item.Properties().food(ChocoFoods.MILK_CHOCOLATE_BAR)));
    public static final RegistryObject<Item> WHITE_CHOCOLATE_BAR = ITEMS.register("white_chocolate_bar",
            () -> new Item(new Item.Properties().food(ChocoFoods.WHITE_CHOCOLATE_BAR)));
    public static final RegistryObject<Item> DARK_CHOCOLATE_BAR = ITEMS.register("dark_chocolate_bar",
            () -> new Item(new Item.Properties().food(ChocoFoods.DARK_CHOCOLATE_BAR)));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ChocoFoods.STRAWBERRY)));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().food(ChocoFoods.BLUEBERRY)));
    public static final RegistryObject<Item> RASPBERRY = ITEMS.register("raspberry",
            () -> new Item(new Item.Properties().food(ChocoFoods.RASPBERRY)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ChocoFoods.ORANGE)));
    public static final RegistryObject<Item> ALMOND = ITEMS.register("almond",
            () -> new Item(new Item.Properties().food(ChocoFoods.ALMOND)));

    /* OTHER */
    public static final RegistryObject<Item> MINT_LEAF = ITEMS.register("mint_leaf",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MILK_CHOCOLATE_INGOT = ITEMS.register("milk_chocolate_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WHITE_CHOCOLATE_INGOT = ITEMS.register("white_chocolate_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_CHOCOLATE_INGOT = ITEMS.register("dark_chocolate_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROASTED_COCOA_BEANS = ITEMS.register("roasted_cocoa_beans",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COCOA_BUTTER_BOWL = ITEMS.register("cocoa_butter_bowl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MILK_BOWL = ITEMS.register("milk_bowl",
            () -> new Item(new Item.Properties()));

    /* TOOLS */

    /* WEAPONS */
//    public static final RegistryObject<Item> WHITE_CHOCOLATE_SWORD = ITEMS.register("white_chocolate_sword",
//            () -> new SwordItem(Tiers.DIAMOND,3, 3, new Item.Properties()));

    /* ARMORS */


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
