package zlurpypets.zlurpypets.managers;

import zlurpypets.zlurpypets.records.Pet;

import java.util.HashMap;
import java.util.Map;

public class PetManager<O> {

    /**
     * This is the petRegistry where the pet is stored and can be looked up later on
     */

    private final Map<String, Pet<O>> petRegistry = new HashMap<>();

    /**
     *
     * @param pet This is used as a param to get the pet's identifier and the pet record to then save in the pet registry and be used later
     *
     */

    public void register(Pet<O> pet) {
        petRegistry.put(pet.identifier(), pet);
    }

}
