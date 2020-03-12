package net.gameslabs.model;

import java.util.ArrayList;
import java.util.Random;

public class Item {
    private String name;
    private String description;
    private ItemCategoryType itemCategoryType;

    public static ArrayList<Item> itemList = new ArrayList<Item>(); // Not the best thing to do here but didnt want to bother much for now

    public static final Item SHRIMPS = new Item(ItemType.SHRIMPS.toString(), "Some shrimps...", ItemCategoryType.FISH);
    public static final Item TUNA = new Item(ItemType.TUNA.toString(), "Some tuna...", ItemCategoryType.FISH);
    public static final Item SALMON = new Item(ItemType.SALMON.toString(), "Some salmon...", ItemCategoryType.FISH);

    public static final Item AIR_RUNE = new Item(ItemType.AIR_RUNE.toString(), "Some air rune...", ItemCategoryType.RUNES);
    public static final Item LAW_RUNE = new Item(ItemType.LAW_RUNE.toString(), "Some law rune...", ItemCategoryType.RUNES);
    public static final Item NATURE_RUNE = new Item(ItemType.NATURE_RUNE.toString(), "Some nature rune...", ItemCategoryType.RUNES);

    public Item(String name, String description, ItemCategoryType itemCategoryType)
    {
        this.name = name;
        this.description = description;
        this.itemCategoryType = itemCategoryType;
        AddItemToList(this);
    }

    public String getName() {
        return name;
    }

    public ItemCategoryType getItemCategoryType() {
        return itemCategoryType;
    }

    public String getDescription() {
        return description;
    }

    public boolean AddItemToList(Item itemToAdd)
    {
        for(Item item : itemList)
        {
            if(item == itemToAdd)
                return false;
        }
        itemList.add(itemToAdd);
        return true;
    }

    public static Item GenerateLootFromType(ItemCategoryType itemCategoryType)
    {
        ArrayList<Item> lootFromType = new ArrayList<Item>();
        for (Item item : itemList)
        {
            if (item.getItemCategoryType() == itemCategoryType)
            {
                lootFromType.add(item);
            }
        }

        if(lootFromType.size() <= 0)
            return null;

        Random rand = new Random(); // Didn't set seed, but its only for a test so..
        return lootFromType.get(rand.nextInt(lootFromType.size()));
    }

    public static Item GenerateLoot() // This is only generating items from the entire list, theres way better ways to add mosnter loot but this is fine for now...
    {
        if(itemList.size() <= 0)
            return null;

        Random rand = new Random(); // Didn't set seed, but its only for a test so..
        return itemList.get(rand.nextInt(itemList.size()));
    }
}
