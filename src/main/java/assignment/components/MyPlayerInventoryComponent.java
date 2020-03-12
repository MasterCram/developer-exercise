package assignment.components;

import net.gameslabs.api.Component;
import net.gameslabs.api.Event;
import net.gameslabs.events.GivePlayerItemEvent;
import net.gameslabs.events.OnPlayerThieveMonsterEvent;

public class MyPlayerInventoryComponent extends Component {
    @Override
    public void onLoad() {
        registerEvent(GivePlayerItemEvent.class, this::onGivePlayerItemEvent);
    }

    private void onGivePlayerItemEvent(GivePlayerItemEvent event) {
        System.out.println("Giving " + event.getItem().getName().toLowerCase() + " to player...");
    }

    @Override
    public void onUnload() {

    }
}
