package github.indiasjulen.chococraft.datagen;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.item.ChocoItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ChocoItemModelProvider extends ItemModelProvider {
    public ChocoItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Chococraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // register all the items
        simpleItem(ChocoItems.ALMOND);
        simpleItem(ChocoItems.ORANGE);
        simpleItem(ChocoItems.STRAWBERRY);
        simpleItem(ChocoItems.BLUEBERRY);
        simpleItem(ChocoItems.RASPBERRY);
        simpleItem(ChocoItems.MINT_LEAF);

        simpleItem(ChocoItems.MILK_CHOCOLATE_BAR);
        simpleItem(ChocoItems.WHITE_CHOCOLATE_BAR);
        simpleItem(ChocoItems.DARK_CHOCOLATE_BAR);

        simpleItem(ChocoItems.MILK_CHOCOLATE_INGOT);
        simpleItem(ChocoItems.WHITE_CHOCOLATE_INGOT);
        simpleItem(ChocoItems.DARK_CHOCOLATE_INGOT);

        simpleItem(ChocoItems.COCOA_BUTTER_BOWL);
        simpleItem(ChocoItems.MILK_BOWL);
        simpleItem(ChocoItems.ROASTED_COCOA_BEANS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Chococraft.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Chococraft.MOD_ID,"item/" + item.getId().getPath()));
    }
}
