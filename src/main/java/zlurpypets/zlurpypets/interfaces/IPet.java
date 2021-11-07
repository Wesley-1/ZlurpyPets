package zlurpypets.zlurpypets.interfaces;

import zlurpypets.zlurpypets.controllers.CommonController;
import zlurpypets.zlurpypets.records.Pet;
import zlurpypets.zlurpypets.records.PetItem;

import java.util.function.Consumer;

public interface IPet<O> {

     private Pet<O> createPet(String name,
                            String identifier,
                            int maxLevel,
                            int startLevel,
                            PetItem item,
                            CommonController<O> controller) {

         return new Pet<O>(name, identifier, maxLevel, startLevel, item, controller);
     }

     private CommonController<O> setupController(O obj, Consumer<O> consumer) {
         return new CommonController<O>(obj, consumer);
     }
}
