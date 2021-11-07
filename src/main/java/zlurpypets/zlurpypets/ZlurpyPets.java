package zlurpypets.zlurpypets;

import org.bukkit.plugin.java.JavaPlugin;

public final class ZlurpyPets extends JavaPlugin {

    private static ZlurpyPets instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static ZlurpyPets getInstance() {
        return instance;
    }
}
