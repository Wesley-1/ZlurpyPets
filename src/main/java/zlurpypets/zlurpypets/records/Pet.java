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
     * This is where the pet is setup
     * Here the pet gets created and where we check the config for certain elements
     * The pet also gets added to the pet registry so it can be used later on and looked up easily by identifier.
     */

    public void setupPet() {
        FileConfiguration config = ZlurpyPets.getInstance().getConfig();
        PetManager<O> manager = new PetManager<O>();

        config.getConfigurationSection("Pets." + identifier).getKeys(false).forEach(key -> {

            Pet<O> configurablePet = new Pet<O>(

                    config.getString(key + ".name"),
                    identifier,
                    config.getInt(key + ".maxLevel"),
                    config.getInt(key + ".startLevel"),

                    new PetItem(
                            Material.valueOf(config.getString(key + ".item.material")),
                            config.getStringList(key + ".item.lore"),
                            config.getString(key + ".item.name")),

                    controller);

                manager.register(configurablePet);
        });
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

        if (toggleManager.activationSet.contains(uuid))
            return true;

        return false;
    }

}
