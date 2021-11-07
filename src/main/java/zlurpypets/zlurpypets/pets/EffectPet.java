package zlurpypets.zlurpypets.pets;


import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import zlurpypets.zlurpypets.interfaces.PetController;
import zlurpypets.zlurpypets.records.Pet;
import zlurpypets.zlurpypets.records.PetItem;
import zlurpypets.zlurpypets.records.controllers.EventPetController;

import java.util.Arrays;
import java.util.function.Consumer;

public class EffectPet implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Pet<EventPetController<Event>> effectPet = new Pet<>(
                "StrengthPet",
                "EFFECT_STRENGTH_PET",
                C,
                 30, 5,
                new PetItem(Material.ANVIL, Arrays.asList("This is an effect pet"), "The pets name"),

                petController -> {
                    petController.eventController()
                } );

    }
}
