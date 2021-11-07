package zlurpypets.zlurpypets.interfaces;

import zlurpypets.zlurpypets.controllers.ActivationController;
import zlurpypets.zlurpypets.controllers.CommonController;
import zlurpypets.zlurpypets.records.Pet;
import zlurpypets.zlurpypets.records.PetItem;

import java.util.function.Consumer;

public interface IPet<O> {

    /**
     *
     * @param name This is how it's identified in code and config.
     * @param identifier This is how it'll be identified in code.
     * @param maxLevel This is how we will check if it can go any further.
     * @param startLevel This is how we see where it should begin.
     * @param item This is the pets item and how it's identified in game.
     * @param controller This is where you input the action from CommonController.
     *
     * @return This returns the pet record.
     *
     */

     private Pet<O> getPet(String name,
                            String identifier,
                            int maxLevel,
                            int startLevel,
                            PetItem item,
                            CommonController<O> controller) {

         return new Pet<O>(name, identifier, maxLevel, startLevel, item, controller);
     }

    /**
     *
     * @param obj This is what the consumer takes.
     * @param consumer This is how you will create the action using the Object.
     *
     * @return This returns the new CommonController you just created.
     *
     */

     private CommonController<O> getCommonController(O obj, Consumer<O> consumer) {
         return new CommonController<O>(obj, consumer);
     }

    /**
     *
     * @param pet This is where you will input the pet they are activating
     *
     * @return This returns the ActivationController
     *
     */

     private ActivationController<O, Pet<O>> getActivationController(Pet<O> pet) {
         return new ActivationController<>(pet);
     }
}
