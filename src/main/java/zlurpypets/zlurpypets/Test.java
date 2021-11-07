package zlurpypets.zlurpypets;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import zlurpypets.zlurpypets.records.PetItem;
import zlurpypets.zlurpypets.records.controllers.EventController;

import java.util.Arrays;

public class Test implements Listener {

    public static void main(String[] args) {
        PetItem petItem = new PetItem(

                Material.ANVIL,
                Arrays.asList(
                        "Hi"
                ),
                "Hi");

        EventController controller = new EventController(petItem);

        controller.setupConsumer(p -> {
            System.out.println(p.name());
        });

    }
}
