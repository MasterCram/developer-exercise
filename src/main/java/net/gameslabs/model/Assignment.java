package net.gameslabs.model;

import net.gameslabs.api.Component;
import net.gameslabs.api.ComponentRegistry;
import net.gameslabs.api.Player;
import net.gameslabs.components.ChartComponent;
import net.gameslabs.events.GetPlayerLevel;
import net.gameslabs.events.GiveXpEvent;
import net.gameslabs.events.OnPlayerThieveMonsterEvent;
import net.gameslabs.events.OnPlayerThieveStallEvent;
import net.gameslabs.implem.PlayerImplem;

import java.util.Arrays;

public class Assignment {

    protected final ComponentRegistry registry;
    private final Player mainPlayer;

    public Assignment(Component ... myComponentsToAdd) {
        registry = new ComponentRegistry();
        Arrays.asList(myComponentsToAdd).forEach(registry::registerComponent);
        registry.registerComponent(new ChartComponent());
        registry.load();
        mainPlayer = PlayerImplem.newPlayer("MyPlayer");
    }

    public final void run() {
        /*registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.CONSTRUCTION, 25));
        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.EXPLORATION, 25));
        GetPlayerLevel getPlayerLevel = new GetPlayerLevel(mainPlayer, Skill.CONSTRUCTION);
        log("Player level", mainPlayer, getPlayerLevel.getLevel());
        runChecks();*/

        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.THIEVING, 25));
        System.out.println("Thieving level: " + getLevel(Skill.THIEVING));

        System.out.println("Attempting to thiev from a goblin...");
        registry.sendEvent(new OnPlayerThieveMonsterEvent(mainPlayer, ThievingMonster.GOBLIN));
        System.out.println();

        System.out.println("Attempting to thiev from a man...");
        registry.sendEvent(new OnPlayerThieveMonsterEvent(mainPlayer, ThievingMonster.MAN));
        System.out.println("Thieving level: " + getLevel(Skill.THIEVING));
        System.out.println();

        System.out.println("Attempting to thiev from a man...");
        registry.sendEvent(new OnPlayerThieveMonsterEvent(mainPlayer, ThievingMonster.MAN));
        System.out.println("Thieving level: " + getLevel(Skill.THIEVING));
        System.out.println();

        System.out.println("Attempting to thiev from a man...");
        registry.sendEvent(new OnPlayerThieveMonsterEvent(mainPlayer, ThievingMonster.MAN));
        System.out.println("Thieving level: " + getLevel(Skill.THIEVING));
        System.out.println();

        System.out.println("Attempting to thiev from a food stall...");
        registry.sendEvent(new OnPlayerThieveStallEvent(mainPlayer, ThievingStall.FOOD_STALL, ItemCategoryType.FISH));
        System.out.println("Thieving level: " + getLevel(Skill.THIEVING));
        System.out.println();

        System.out.println("Attempting to thiev from a magic stall...");
        registry.sendEvent(new OnPlayerThieveStallEvent(mainPlayer, ThievingStall.MAGIC_STALL, ItemCategoryType.RUNES));
        System.out.println("Thieving level: " + getLevel(Skill.THIEVING));
        System.out.println();

        System.out.println("Attempting to thiev from a goblin...");
        registry.sendEvent(new OnPlayerThieveMonsterEvent(mainPlayer, ThievingMonster.GOBLIN));
        System.out.println("Thieving level: " + getLevel(Skill.THIEVING));
        System.out.println();

        registry.unload();
    }

    private void runChecks() {
        if (getLevel(Skill.EXPLORATION) != 1) throw new AssignmentFailed("Exploration XP should be set to level 1");
        if (getLevel(Skill.CONSTRUCTION) != 2) throw new AssignmentFailed("Construction XP should be set to level 2");
    }

    private int getLevel(Skill skill) {
        GetPlayerLevel getPlayerLevel = new GetPlayerLevel(mainPlayer, skill);
        registry.sendEvent(getPlayerLevel);
        return getPlayerLevel.getLevel();
    }

    public void log(Object ... arguments) {
        System.out.println(Arrays.asList(arguments).toString());
    }
}
