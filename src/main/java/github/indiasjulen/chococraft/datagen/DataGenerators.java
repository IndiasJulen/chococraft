package github.indiasjulen.chococraft.datagen;

import github.indiasjulen.chococraft.Chococraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Chococraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        generator.addProvider(true, new ChocoRecipeProvider(packOutput));
        generator.addProvider(true, ChocoLootTableProvider.create(packOutput));
        generator.addProvider(true, new ChocoItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ChocoWorldGenProvider(packOutput, lookUpProvider));
    }
}
