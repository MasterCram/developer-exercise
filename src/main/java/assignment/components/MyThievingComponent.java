package assignment.components;

import net.gameslabs.api.Component;
import net.gameslabs.api.Event;
import net.gameslabs.api.Player;
import net.gameslabs.events.*;
import net.gameslabs.model.Item;
import net.gameslabs.model.ItemCategoryType;
import net.gameslabs.model.Skill;

public class MyThievingComponent extends Component {
    @Override
    public void onLoad() {
        registerEvent(OnPlayerThieveMonsterEvent.class, this::onPlayerThieveMonsterEvent);
        registerEvent(OnPlayerThieveStallEvent.class, this::onPlayerThieveStallEvent);
    }

    private void onPlayerThieveMonsterEvent(OnPlayerThieveMonsterEvent event) {
        GetPlayerLevel getPlayerLevel = new GetPlayerLevel(event.getPlayer(), Skill.THIEVING);
        send(getPlayerLevel);
        if(getPlayerLevel.getLevel() >= event.getThievingMonster().getLevelRequired()) {
            System.out.println("Succesfully steal from a " + event.getThievingMonster().getName().toLowerCase() + ".");
            send(new GiveXpEvent(event.getPlayer(), Skill.THIEVING, event.getThievingMonster().getExp() * 2)); // double exp for monster
            send(new GivePlayerItemEvent(event.getPlayer(), Item.GenerateLoot()));
        }
        else
        {
            System.out.println("Not enough thieving level to do that. (" + getPlayerLevel.getLevel() + "/" + event.getThievingMonster().getLevelRequired() + ")");
        }
    }

    private void onPlayerThieveStallEvent(OnPlayerThieveStallEvent event) {
        GetPlayerLevel getPlayerLevel = new GetPlayerLevel(event.getPlayer(), Skill.THIEVING);
        send(getPlayerLevel);
        if(getPlayerLevel.getLevel() >= event.getThievingStall().getLevelRequired()) {
            System.out.println("Succesfully steal from " + event.getThievingStall().getName().toLowerCase() + ".");
            send(new GiveXpEvent(event.getPlayer(), Skill.THIEVING, event.getThievingStall().getExp()));
            send(new GivePlayerItemEvent(event.getPlayer(), Item.GenerateLootFromType(event.getItemCategoryType())));
        }
            else
        {
            System.out.println("Not enough thieving level to do that. (" + getPlayerLevel.getLevel() + "/" + event.getThievingStall().getLevelRequired() + ")");
        }
    }


    @Override
    public void onUnload() {

    }
}
