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
    public void onInteract(PlayerInteractEvent event) {

        Pet<Event> pet = new Pet<>("Pet", "EFFECT", 10, 1, new PetItem(Material.ANVIL, Arrays.asList("Hi"), "Hi"),

                new CommonController<>(event,
                        eventObj -> {

                    PlayerInteractEvent obj = (PlayerInteractEvent) eventObj;

                    obj.getClickedBlock().getType();

                        }));


        pet.setupPet();

        pet.controller().runTaskLater(20);

    }

}
