package de.syskoh.customCrafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class CustomCrafting extends JavaPlugin {

    public static final ItemStack customItem = createCustomItem();
    public static final ItemStack customIngridient = customIngridient();


    @Override
    public void onEnable() {
        // Plugin startup logic
        createCustomRecipe();

        // Register the give command
        getCommand("givecustomitem").setExecutor(new GiveCommand()); // Gives the custom ingridient item
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static ItemStack createCustomItem() {
        // Create a new ItemStack
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);

        // Set the display name of the item
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§6Custom Diamond Sword");
        item.setItemMeta(meta);

        // Return the item
        return item;
    }

    private static ItemStack customIngridient() {
        // Create a new ItemStack
        ItemStack item = new ItemStack(Material.DIAMOND);

        // Set the display name of the item
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bCustom Diamond");
        meta.setLore(List.of("§7This is a custom diamond", "§7used for crafting"));
        item.setItemMeta(meta);

        // Return the item
        return item;
    }

    private void createCustomRecipe() {
        // Define the result of the recipe
        ItemStack result = customItem;

        // Create a NamespacedKey for the recipe
        NamespacedKey key = new NamespacedKey(this, "custom_diamond_sword");

        // Create the recipe
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(" D ", " D ", " S ");
        recipe.setIngredient('D', new RecipeChoice.ExactChoice(customIngridient));
        recipe.setIngredient('S', Material.STICK);

        // Register the recipe
        Bukkit.addRecipe(recipe);
    }
}