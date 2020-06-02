package GUI;

import Utility.Creature;
import Utility.Item;

public class EatScreen extends InventoryBasedScreen {

    public EatScreen(Creature player) {
        super(player);
    }

    protected String getVerb() {
        return "eat";
    }

    protected boolean isAcceptable(Item item) {
        return item.foodValue() != 0;
    }

    protected Screen use(Item item) {
        player.eat(item);
        return null;
    }
}
