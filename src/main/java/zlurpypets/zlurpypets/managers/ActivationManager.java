package zlurpypets.zlurpypets.managers;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ActivationManager {

    /**
     * This is the Set used to check if the user has a pet activated or not.
     */

    public final Set<UUID> activationSet;

    public ActivationManager() {
        this.activationSet = new HashSet<>();
    }

    /**
     *
     * @param userID This is used to identify the user
     *
     */
    public void addPlayer(UUID userID) {
        if (activationSet.contains(userID))
            return;

        activationSet.add(userID);

    }

    /**
     *
     * @param userID This is used to identify the user
     *
     */

    public void removePlayer(UUID userID) {
        if (!activationSet.contains(userID))
            return;

        activationSet.remove(userID);

    }
}
