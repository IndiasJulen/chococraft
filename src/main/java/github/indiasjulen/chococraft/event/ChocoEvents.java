package github.indiasjulen.chococraft.event;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.item.ChocoItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Chococraft.MOD_ID)
public class ChocoEvents {

    /**
     * Method for handling the event when the player interacts when an entity, if the entity is a cow and the
     * player has an empty bowl in its main hand, the bowl will be filled with milk.
     */
    @SubscribeEvent
    public static void onRightClickBowl(PlayerInteractEvent.EntityInteract event) {
        if(!(event.getSide() == LogicalSide.SERVER)) {
            if (event.getTarget() instanceof Cow) {
                if (event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getItem().equals(Items.BOWL)) {

                    event.getEntity().setItemInHand(InteractionHand.MAIN_HAND,
                            new ItemStack(Items.BOWL, event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getCount() - 1));
                    event.getEntity().addItem(new ItemStack(ChocoItems.MILK_BOWL.get()));
                }
            }
        }
    }
}
