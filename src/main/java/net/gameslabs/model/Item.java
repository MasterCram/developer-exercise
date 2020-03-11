package net.gameslabs.model;

public class Item {
    private String name;

    public static Item empty = new Item("empty");
    public static Item coins = new Item("coins");
    public static Item coal = new Item("Coal");

    public Item(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
