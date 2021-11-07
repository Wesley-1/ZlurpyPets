package zlurpypets.zlurpypets.records;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

/**
 *
 * @param material This will be the items material
 * @param lore This will be the lore of the item, you can use color codes '&'
 * @param name This will be the name of the item, you can use color codes '&'
 *
 */
public record PetItem(Material material, List<String> lore, String name) {

    /**
     *
     * @return This returns the itemstack for the pet.
     */
    public ItemStack getItem() {

        ItemStack petItem = new ItemStack(material);
        ItemMeta itemMeta = petItem.getItemMeta();

        itemMeta.setLore(
                Collections.singletonList(
                        ChatColor.translateAlternateColorCodes(
                                '&', String.valueOf(lore))));

        itemMeta.setDisplayName(
                ChatColor.translateAlternateColorCodes(
                        '&', name));

        petItem.setItemMeta(itemMeta);

        /*
        Need to do the nbt for this pet
         */

        return petItem;
    }

    /**
     *
     * @param player Player variable
     * @param updatedLore This will be what the lore is set to
     * @param updatedName This will be what the name is set to
     *
     */
    public void update(Player player, List<String> updatedLore, String updatedName) {

        Inventory inv = player.getInventory();

        if (!inv.contains(getItem())) {
            System.out.println("The user " + player + " doesn't seem to have the pet in their inventory. Is this a mistake?");

        } else {

            for (ItemStack itemStack : inv.getContents()) {

                if (itemStack != getItem())
                    return;

                ItemMeta itemMeta = getItem().getItemMeta();

                itemMeta.setLore(
                        Collections.singletonList(
                                ChatColor.translateAlternateColorCodes(
                                        '&', String.valueOf(updatedLore))));

                itemMeta.setDisplayName(
                        ChatColor.translateAlternateColorCodes(
                                '&', updatedName));

                getItem().setItemMeta(itemMeta);

            }
        }
    }
}
