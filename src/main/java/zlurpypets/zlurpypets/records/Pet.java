package zlurpypets.zlurpypets.records;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import zlurpypets.zlurpypets.ZlurpyPets;
import zlurpypets.zlurpypets.interfaces.PetController;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @param petController Pets action controller
 * @param controller The consumer that uses the action
 * @param identifier This is used to identify the pet in code and config
 * @param item This is the pets item, this has the lore, material and name.
 * @param maxLevel This is the pets max level it can reach
 * @param name This is the pets name
 * @param startLevel This is the level the pet will start at
 *
 */
public record Pet<C extends PetController>(String name,
                                               String identifier,
                                               C petController,
                                               int maxLevel,
                                               int startLevel,
                                               PetItem item,
                                               Consumer<PetController> controller) {

    private static final Map<String, Pet<PetController>> petMap = new HashMap<>();

    /**
     *
     * @param identifier This is what you can use to set identifier
     * @param controller This is how you will use different controllers with the consumer
     */
    public void setupPet(String identifier, Consumer<PetController> controller) {
        FileConfiguration config = ZlurpyPets.getInstance().getConfig();

        config.getConfigurationSection("Pets." + identifier).getKeys(false).forEach(key -> {

            Pet<PetController> configurablePet = new Pet<PetController>(

                    config.getString(key + ".name"),
                    identifier,
                    petController,
                    config.getInt(key + ".maxLevel"),
                    config.getInt(key + ".startLevel"),

                    new PetItem(
                            Material.valueOf(config.getString(key + ".item.material")),
                            config.getStringList(key + ".item.lore"),
                            config.getString(key +  ".item.name")
                    ),
                     controller);

            petMap.put(configurablePet.identifier, configurablePet);

        });
    }

    /**
     *
     * @param delay How delayed the task is
     *
     */
    public void runTaskLater(long delay) {
        Bukkit.getScheduler().runTaskLater(ZlurpyPets.getInstance(), () ->
                controller().accept(petController), delay);
    }

    /**
     *
     * @param delay How delayed the task is
     * @param period Length till next task
     *
     */
    public void runTaskRepeatingSync(long delay, long period) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(ZlurpyPets.getInstance(), () ->
                controller().accept(petController), delay, period);
    }
}
