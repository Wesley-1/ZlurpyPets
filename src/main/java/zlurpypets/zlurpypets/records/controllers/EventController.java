package zlurpypets.zlurpypets.records.controllers;

import zlurpypets.zlurpypets.interfaces.IController;
import zlurpypets.zlurpypets.records.PetItem;

import java.util.function.Consumer;

public class EventController extends CommonController<PetItem> {

    public EventController(PetItem obj) {
        super(obj, petItem -> {
            System.out.println(petItem.name());
        });
    }
}
