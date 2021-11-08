package zlurpypets.zlurpypets.pets.types;

import org.bukkit.entity.Player;
import zlurpypets.zlurpypets.abstracts.PetAPI;
import zlurpypets.zlurpypets.controllers.ActivationController;
import zlurpypets.zlurpypets.controllers.CommonController;
import zlurpypets.zlurpypets.records.Pet;
import zlurpypets.zlurpypets.records.PetItem;

public class MessageSending<P extends Player> extends PetAPI<P> {

    /**
     * @param name             This is the pets name
     * @param identifier       This is the pets unique identifier in code
     * @param maxLevel         This is the level the pet will stop at
     * @param startLevel       This is the level the pet will begin at
     * @param item             This is the petItem, this is how you will setup the item for the pet
     * @param commonController This is the common controller, this is how you setup actions
     */

    public MessageSending(String name, String identifier, int maxLevel, int startLevel, PetItem item, CommonController<P> commonController) {
        super(name, identifier, maxLevel, startLevel, item, commonController);
    }

}