package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;
import net.gameslabs.model.ThievingMonster;

public class OnPlayerThieveMonsterEvent extends PlayerEvent {
    ThievingMonster thievingMonster;

    public OnPlayerThieveMonsterEvent(Player player, ThievingMonster thievingMonster) {
        super(player);
        this.thievingMonster = thievingMonster;
    }

    public ThievingMonster getThievingMonster() {
        return thievingMonster;
    }
}
