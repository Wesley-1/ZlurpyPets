package zlurpypets.zlurpypets.managers;

import zlurpypets.zlurpypets.records.Pet;

import java.util.HashMap;
import java.util.Map;

public class PetManager<O> {

    private final Map<String, Pet<O>> petRegistry = new HashMap<>();

    public void register(Pet<O> pet) {
        petRegistry.put(pet.identifier(), pet);
    }
}
