package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;
import net.gameslabs.model.ItemCategoryType;
import net.gameslabs.model.ThievingStall;
import net.gameslabs.model.ThievingStallType;

public class OnPlayerThieveStallEvent extends PlayerEvent {
    private ThievingStall thievingStall;
    private ItemCategoryType itemCategoryType;

    public OnPlayerThieveStallEvent(Player player, ThievingStall thievingStall, ItemCategoryType itemCategoryType) {
        super(player);
        this.thievingStall = thievingStall;
        this.itemCategoryType = itemCategoryType;
    }

    public ThievingStall getThievingStall() {
        return thievingStall;
    }

    public ItemCategoryType getItemCategoryType() {
        return itemCategoryType;
    }
}
