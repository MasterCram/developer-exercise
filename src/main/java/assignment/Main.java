package assignment;

import assignment.components.MyPlayerInventoryComponent;
import assignment.components.MyThievingComponent;
import assignment.components.MyXPBoosterComponent;
import net.gameslabs.model.Assignment;

public class Main {

    public static void main(String[] args) {
        new Assignment(
            new MyXPBoosterComponent(),
                new MyThievingComponent(),
                new MyPlayerInventoryComponent()
        ).run();
    }
}
