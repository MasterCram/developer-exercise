package assignment.components;

import net.gameslabs.api.Component;
import net.gameslabs.events.BlockBreakEvent;
import net.gameslabs.events.GiveXpEvent;
import net.gameslabs.model.AssignmentFailed;
import net.gameslabs.model.Item;
import net.gameslabs.model.Skill;

public class MyMiningComponent extends Component {
    @Override
    public void onLoad() {
        registerEvent(BlockBreakEvent.class, this::onBlockBreak);
    }

    private void onBlockBreak(BlockBreakEvent event)
    {
        // If the mining level is high enough, do the actions, else we give an error.
        if(event.getMiningLevel() >= event.getBlock().getLevel()) {
            send(new GiveXpEvent(event.getPlayer(), Skill.MINING, event.getBlock().getExp()));
            event.getPlayer().getInventory().giveItem(Item.coal, 1);
            System.out.println("Succesfully mined coal ore");
        }
        else
        {
            System.out.println("Not enough mining level, you are level " + event.getMiningLevel() + " and need level " + event.getBlock().getLevel());
        }
    }
    @Override
    public void onUnload() {

    }
}
