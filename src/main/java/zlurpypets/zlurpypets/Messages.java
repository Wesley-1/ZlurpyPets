package zlurpypets.zlurpypets;

import org.bukkit.ChatColor;

public enum Messages {

    /**
     * This is where we store the messages for the plugin
     */

    ACTIVATED("&a&lThe pet has been activated."),
    DEACTIVATED("&c&lThis pet has been deactivated.");

    private final String message;

    /**
     *
     * @param string This is the message that will end up being sent and where it gets turned into a colored message.
     *
     */

    Messages(String string) {
        this.message = ChatColor.translateAlternateColorCodes('&', string);
    }

    /**
     *
     * @return This returns the message
     *
     */

    public String getMessage() {
        return message;
    }

}
