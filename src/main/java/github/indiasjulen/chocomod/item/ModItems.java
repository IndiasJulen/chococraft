package github.indiasjulen.chocomod.item;

import github.indiasjulen.chocomod.Chocomod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Chocomod.MOD_ID);

    // the zircon item registered in the creative custom tab
    public static final RegistryObject<Item> MILK_CHOCOLATE_INGOT = ITEMS.register("milk_chocolate_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
