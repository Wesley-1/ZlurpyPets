package zlurpypets.zlurpypets.records;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import zlurpypets.zlurpypets.ZlurpyPets;
import zlurpypets.zlurpypets.interfaces.IController;
import zlurpypets.zlurpypets.records.controllers.CommonController;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @param petController Pets action controller
 * @param identifier This is used to identify the pet in code and config
 * @param item This is the pets item, this has the lore, material and name.
 * @param maxLevel This is the pets max level it can reach
 * @param name This is the pets name
 * @param startLevel This is the level the pet will start at
 *
 */
public record Pet<O>(String name,
                  String identifier,
                  CommonController<O> controller,
                  int maxLevel,
                  int startLevel,
                  PetItem item) {

    static Map<String, Pet<Object>> petMap = new HashMap<>();

    /**
     *
     * @param identifier This is what you can use to set identifier
     */
    public void setupPet(String identifier) {
        FileConfiguration config = ZlurpyPets.getInstance().getConfig();

        config.getConfigurationSection("Pets." + identifier).getKeys(false).forEach(key -> {

            Pet<O> configurablePet = new Pet<>(

                    config.getString(key + ".name"),
                    identifier,
                    controller,
                    config.getInt(key + ".maxLevel"),
                    config.getInt(key + ".startLevel"),

                    new PetItem(
                            Material.valueOf(config.getString(key + ".item.material")),
                            config.getStringList(key + ".item.lore"),
                            config.getString(key + ".item.name")
                    ));

            petMap.put(configurablePet.identifier, configurablePet);

        });
    }
}
