package github.indiasjulen.chococraft.block.entity;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.block.ChocoBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChocoBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Chococraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<ChocolateRefinerBlockEntity>> CHOCOLATE_REFINER =
            BLOCK_ENTITIES.register("chocolate_refiner", () ->
                    BlockEntityType.Builder.of(ChocolateRefinerBlockEntity::new, ChocoBlocks.CHOCOLATE_REFINER_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
