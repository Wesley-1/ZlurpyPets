package zlurpypets.zlurpypets.abstracts;

import lombok.Getter;
import zlurpypets.zlurpypets.controllers.ActivationController;
import zlurpypets.zlurpypets.controllers.CommonController;
import zlurpypets.zlurpypets.records.Pet;
import zlurpypets.zlurpypets.records.PetItem;


public abstract class PetAPI<O> {

    @Getter final String name;
    @Getter final String identifier;
    @Getter final int maxLevel;
    @Getter final int startLevel;
    @Getter final PetItem item;
    @Getter final CommonController<O> commonController;

    /**
     *
     * @param name This is the pets name
     * @param identifier This is the pets unique identifier in code
     * @param maxLevel  This is the level the pet will stop at
     * @param startLevel This is the level the pet will begin at
     * @param item This is the petItem, this is how you will setup the item for the pet
     * @param commonController This is the common controller, this is how you setup actions
     *
     */

    public PetAPI(String name, String identifier, int maxLevel, int startLevel, PetItem item, CommonController<O> commonController) {
        this.name = name;
        this.identifier = identifier;
        this.maxLevel = maxLevel;
        this.startLevel = startLevel;
        this.item = item;
        this.commonController = commonController;
    }

    /**
     *
     * @return This returns the activation manager allowing for you to toggle this pet
     *
     */

    public ActivationController<O, Pet<O>> getActivationController() {
        return new ActivationController<>(
                new Pet<O>(this.name, this.identifier, this.maxLevel, this.startLevel, this.item, this.commonController));
    }
}
