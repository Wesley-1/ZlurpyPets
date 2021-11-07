package zlurpypets.zlurpypets.interfaces;

import org.bukkit.event.Event;

public interface Events<T extends Event> {
    T event();

}
