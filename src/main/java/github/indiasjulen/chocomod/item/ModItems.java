package github.indiasjulen.chocomod.item;

import github.indiasjulen.chocomod.Chocomod;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
