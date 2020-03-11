package assignment.components;

import net.gameslabs.api.Component;
import net.gameslabs.api.Player;
import net.gameslabs.events.BlockBreakEvent;
import net.gameslabs.events.InventoryCheckEvent;
import net.gameslabs.implem.PlayerImplem;
import net.gameslabs.model.Assignment;
import net.gameslabs.model.Item;

public class MyInventoryComponent extends Component {

    @Override
    public void onLoad() {
        registerEvent(InventoryCheckEvent.class, this::onInventoryCheck);
    }

    private void onInventoryCheck(InventoryCheckEvent event)
    {
        for(int i = 0; i < 36; i++)
        {
            if(event.getPlayer().getInventory().getSlot()[i].getItem() == Item.coins)
            {
                event.getPlayer().getInventory().getSlot()[i].removeItem(event.getQuantity());
                return;
            }
        }
        System.out.println("Item not found!");
    }

    @Override
    public void onUnload() {

    }


}
