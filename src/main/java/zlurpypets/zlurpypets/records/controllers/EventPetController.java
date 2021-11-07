package zlurpypets.zlurpypets.records.controllers;

import org.bukkit.event.Event;
import zlurpypets.zlurpypets.interfaces.PetController;

import java.util.function.Consumer;

public final class EventPetController<E extends Event> implements PetController {

    private final E event;

    public EventPetController(E event) {
        this.event = event;
    }

    public E getEvent() {
        return event;
    }
}
