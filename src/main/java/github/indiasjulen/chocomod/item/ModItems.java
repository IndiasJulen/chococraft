package github.indiasjulen.chocomod.item;

import github.indiasjulen.chocomod.Chocomod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Chocomod.MOD_ID);

    // Milk chocolate ingot
    public static final RegistryObject<Item> MILK_CHOCOLATE_INGOT = ITEMS.register("milk_chocolate_ingot",
            () -> new Item(new Item.Properties()));

    // White chocolate ingot
    public static final RegistryObject<Item> WHITE_CHOCOLATE_INGOT = ITEMS.register("white_chocolate_ingot",
            () -> new Item(new Item.Properties()));

    // Dark chocolate ingot
    public static final RegistryObject<Item> DARK_CHOCOLATE_INGOT = ITEMS.register("dark_chocolate_ingot",
            () -> new Item(new Item.Properties()));

    // Roasted cocoa beans
    public static final RegistryObject<Item> ROASTED_COCOA_BEANS = ITEMS.register("roasted_cocoa_beans",
            () -> new Item(new Item.Properties()));

    // Roasted cocoa beans
    public static final RegistryObject<Item> COCOA_BUTTER_BOWL = ITEMS.register("cocoa_butter_bowl",
            () -> new Item(new Item.Properties()));

    // Roasted cocoa beans
    public static final RegistryObject<Item> WHITE_CHOCOLATE_SWORD = ITEMS.register("white_chocolate_sword",
            () -> new SwordItem(Tiers.DIAMOND,3, 3, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
