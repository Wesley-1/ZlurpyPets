package zlurpypets.zlurpypets.pets;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import zlurpypets.zlurpypets.records.Pet;
import zlurpypets.zlurpypets.records.controllers.CommonController;
import zlurpypets.zlurpypets.records.controllers.EventController;

public class EffectPet implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Pet<EventController> pet = new Pet<EventController>("")

    }

}
