package net.gameslabs.events;

import net.gameslabs.api.Event;
import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;
import net.gameslabs.model.Assignment;
import net.gameslabs.model.Item;

public class InventoryCheckEvent extends PlayerEvent {
    private Item item;
    private int quantity;

    public InventoryCheckEvent(Player player, Item item, int quantity)
    {
        super(player);
        this.item = item;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }

}
