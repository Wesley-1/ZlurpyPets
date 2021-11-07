package zlurpypets.zlurpypets.interfaces;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import zlurpypets.zlurpypets.records.Pet;
import zlurpypets.zlurpypets.records.controllers.EventPetController;
import zlurpypets.zlurpypets.records.controllers.PlayerPetController;

public interface PetController {

    EventPetController<Event> eventController();

}
