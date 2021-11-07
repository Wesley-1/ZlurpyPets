package zlurpypets.zlurpypets.records.controllers;

import org.bukkit.Bukkit;
import zlurpypets.zlurpypets.ZlurpyPets;
import zlurpypets.zlurpypets.interfaces.IController;

import java.util.function.Consumer;

public class CommonController<T extends Object> implements IController {

    private final T obj;
    private final Consumer<T> consumer;

    public CommonController(T obj, Consumer<T> consumer) {
        this.obj = obj;
        this.consumer = consumer;
    }

    /**
     *
     * @param delay How delayed the task is
     *
     */
    public void runTaskLater(long delay) {
        Bukkit.getScheduler().runTaskLater(ZlurpyPets.getInstance(), () ->
                this.consumer.accept(obj), delay);
    }

    /**
     *
     * @param delay How delayed the task is
     * @param period Length till next task
     *
     */

    public void runTaskRepeatingSync(long delay, long period) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(ZlurpyPets.getInstance(), () ->
                consumer.accept(obj), delay, period);
    }

}
