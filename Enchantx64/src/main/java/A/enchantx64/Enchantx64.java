package A.enchantx64;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Enchantx64 extends JavaPlugin {

    // A map for all ores
    final static public HashMap<Material, String> Ores = new HashMap<>(8);

    public Enchantx64() {
        // Add ores to map

        Ores.put(Material.DIAMOND, "Diamond");
        Ores.put(Material.EMERALD, "Emerald");
        Ores.put(Material.GOLD_INGOT, "Gold");
        Ores.put(Material.IRON_INGOT, "Iron");
        Ores.put(Material.COPPER_INGOT, "Copper");
        Ores.put(Material.COAL, "Coal");
        Ores.put(Material.LAPIS_LAZULI, "Lapis Lazuli");
        Ores.put(Material.NETHERITE_INGOT, "Netherite");
    }

    @Override
    public void onEnable() {
        // add event
        getServer().getPluginManager().registerEvents(new x64_OreDrop(), this);
    }


}

class x64_OreDrop implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e)
    {
        ItemStack itemS = e.getItemDrop().getItemStack();

        if(itemS.getAmount() == 64 &&
                Enchantx64.Ores.containsKey(itemS.getType()))
        {
            itemS.setAmount(1);
            itemS.addUnsafeEnchantment(Enchantment.MENDING, 1);

            ItemMeta itemM = itemS.getItemMeta();

            itemM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemM.setItemName("Enchanted " + Enchantx64.Ores.get(itemS.getType()));

            itemS.setItemMeta(itemM);
        }
    }
}
