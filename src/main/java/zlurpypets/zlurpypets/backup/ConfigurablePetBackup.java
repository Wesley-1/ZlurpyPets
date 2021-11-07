package zlurpypets.zlurpypets.backup;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import zlurpypets.zlurpypets.ZlurpyPets;
import zlurpypets.zlurpypets.records.PetItem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @param event Pets action event
 * @param action The consumer that uses the action
 * @param identifier This is used to identify the pet in code and config
 * @param item This is the pets item, this has the lore, material and name.
 * @param maxLevel This is the pets max level it can reach
 * @param name This is the pets name
 * @param startLevel This is the level the pet will start at
 *
 */
public record ConfigurablePetBackup<E extends Event>(String name,
                                                     String identifier,
                                                     E event, Consumer<Event> action,
                                                     int maxLevel,
                                                     int startLevel,
                                                     PetItem item) {

    private static final Map<String, ConfigurablePetBackup<Event>> petMap = new HashMap<>();

    /**
     *
     * @param identifier This is what you can use to set identifier
     * @param actions This is what you use to create the pets actions
     */
    public void setupPet(String identifier, Consumer<Event> actions) {
        FileConfiguration config = ZlurpyPets.getInstance().getConfig();

        config.getConfigurationSection("Pets." + identifier).getKeys(false).forEach(key -> {

            ConfigurablePetBackup<Event> configurablePet = new ConfigurablePetBackup<>(config.getString(key + ".name"),
                    identifier,
                    event,
                    actions,
                    config.getInt(key + ".maxLevel"),
                    config.getInt(key + ".startLevel"),

                    new PetItem(
                            Material.valueOf(config.getString(key + ".item.material")),
                            config.getStringList(key + ".item.lore"),
                            config.getString(key +  ".item.name")
                    ));

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
                action().accept(event), delay);
    }

    /**
     *
     * @param delay How delayed the task is
     * @param period Length till next task
     *
     */
    public void runTaskRepeatingSync(long delay, long period) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(ZlurpyPets.getInstance(), () ->
                action().accept(event), delay, period);
    }
}
