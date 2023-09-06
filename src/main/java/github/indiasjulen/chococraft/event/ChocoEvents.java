package github.indiasjulen.chococraft.event;

import github.indiasjulen.chococraft.Chococraft;
import github.indiasjulen.chococraft.item.ChocoItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ChocoEvents {

    @Mod.EventBusSubscriber(modid = Chococraft.MOD_ID)
    public static class ForgeEvents {
        /**
         * Method for handling the event when the player interacts with an entity, if the entity is a cow and the
         * player has an empty bowl in its main hand, the bowl will be filled with milk.
         */
        @SubscribeEvent
        public static void onRightClickBowl(PlayerInteractEvent.EntityInteract event) {
            if(!event.getLevel().isClientSide()) {
                if(event.getHand().equals(InteractionHand.MAIN_HAND)) {
                    // if the target entity is a cow
                    if (event.getTarget() instanceof Cow cow) {
                        // check if the target entity is an adult cow and if the player holds an empty bowl
                        if ((cow.getAge() != -1) && event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getItem().equals(Items.BOWL)) {
                            // if the player has only one bowl in the hand, replace it with a milk bowl
                            if(event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getCount() == 1) {
                                event.getEntity().setItemInHand(InteractionHand.MAIN_HAND,
                                        new ItemStack(ChocoItems.MILK_BOWL.get(), 1));
                            // else add a milk bowl in a separate inventory slot
                            } else {
                                event.getEntity().setItemInHand(InteractionHand.MAIN_HAND,
                                        new ItemStack(Items.BOWL, event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getCount() - 1));
                                event.getEntity().addItem(new ItemStack(ChocoItems.MILK_BOWL.get()));
                            }
                        }
                    }
                }
            }
        }

        /**
         * Method for handling the event when the player right-clicks a grown fruit tree. If the fruit is fully grown the leaf block will drop a fruit.
         */
        @SubscribeEvent
        public static void onRightClickLeaf(PlayerInteractEvent.RightClickBlock event) {
            // do stuff

        }
    }


}
