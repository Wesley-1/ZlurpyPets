package zlurpypets.zlurpypets.records;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import zlurpypets.zlurpypets.ZlurpyPets;
import zlurpypets.zlurpypets.controllers.CommonController;
import zlurpypets.zlurpypets.managers.PetManager;

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

    public void setupPet() {
        FileConfiguration config = ZlurpyPets.getInstance().getConfig();

        config.getConfigurationSection("Pets." + identifier).getKeys(false).forEach(key -> {

            Pet<O> configurablePet = new Pet<O>(

                    config.getString(key + ".name"),
                    identifier,
                    config.getInt(key + ".maxLevel"),
                    config.getInt(key + ".startLevel"),

                    new PetItem(
                            Material.valueOf(config.getString(key + ".item.material")),
                            config.getStringList(key + ".item.lore"),
                            config.getString(key + ".item.name")
                    ),

                    controller);

                PetManager<O> manager = new PetManager<O>();
                manager.register(configurablePet);
        });
    }
}
