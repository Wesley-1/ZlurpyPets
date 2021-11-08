package zlurpypets.zlurpypets.records;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import zlurpypets.zlurpypets.ZlurpyPets;
import zlurpypets.zlurpypets.controllers.CommonController;
import zlurpypets.zlurpypets.managers.ActivationManager;
import zlurpypets.zlurpypets.managers.PetManager;

import java.util.UUID;

/**
 *
 * @param controller This is the common controller for actions
 * @param identifier This is used to identify the pet in code and config
 * @param item This is the pets item, this has the lore, material and name.
 * @param maxLevel This is the pets max level it can reach
 * @param name This is the pets name
 * @param startLevel This is the level the pet will start at
 *
 */
public record Pet<O>(String name,
                  String identifier,
                  int maxLevel,
                  int startLevel,
                  PetItem item,
                  CommonController<O> controller) {

    /**
     * Here the pet is created and stored in the manager
     */

    public void setupPet() {
        PetManager<O> manager = new PetManager<O>();

        Pet<O> pet = new Pet<O>(
                name,
                identifier,
                maxLevel,
                startLevel,
                item,
                controller);

        manager.register(pet);
    }

    /**
     *
     * @param uuid This is used to identify the user in the set
     *
     * @return This returns a true or false value that tells you if the user has a pet active.
     *
     */

    public boolean isActive(UUID uuid) {
        ActivationManager toggleManager = new ActivationManager();
        return toggleManager.activationSet.contains(uuid);
    }

}
