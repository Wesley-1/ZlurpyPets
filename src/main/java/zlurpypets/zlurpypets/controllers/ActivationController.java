package zlurpypets.zlurpypets.controllers;

import org.bukkit.entity.Player;
import zlurpypets.zlurpypets.Messages;
import zlurpypets.zlurpypets.managers.ActivationManager;
import zlurpypets.zlurpypets.records.Pet;

public class ActivationController<O, P extends Pet<O>> {

    private final P pet;

    /**
     *
     * @param pet This is the pet that they have active.
     *
     */

    public ActivationController(P pet) {
        this.pet = pet;
    }

    /**
     *
     * @param player Used to get users unique ID  and check if in set.
     *
     */

    public void toggle(Player player) {
        ActivationManager toggleManager = new ActivationManager();

        if(pet.isActive(player.getUniqueId())) {

            toggleManager.removePlayer(player.getUniqueId());
            player.sendMessage(String.valueOf(Messages.DEACTIVATED));

        } else {

            toggleManager.addPlayer(player.getUniqueId());
            player.sendMessage(String.valueOf(Messages.ACTIVATED));

        }
    }
}
