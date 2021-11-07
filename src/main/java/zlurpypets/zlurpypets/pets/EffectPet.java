package zlurpypets.zlurpypets.pets;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import zlurpypets.zlurpypets.controllers.CommonController;
import zlurpypets.zlurpypets.records.Pet;
import zlurpypets.zlurpypets.records.PetItem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EffectPet implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent eventInteraction) {

        CommonController<Event> effectController = new CommonController<>(eventInteraction,
        eventObj -> {

            PlayerInteractEvent event = (PlayerInteractEvent) eventObj;

            event.getPlayer().sendMessage(event.getClickedBlock().getType().toString());

        });

        Pet<Event> pet = new Pet<>("Pet", "EFFECT", 10, 1, new PetItem(Material.ANVIL, Arrays.asList("Hi"), "Hi"), effectController);

        pet.setupPet();

        pet.controller().runTaskLater(20);

    }

}
