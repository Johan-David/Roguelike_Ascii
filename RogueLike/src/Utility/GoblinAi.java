package Utility;

import java.util.List;

public class GoblinAi extends CreatureAi {
    private Creature player;

    public GoblinAi(Creature creature, Creature player) {
        super(creature);
        this.player = player;
    }

    public void onUpdate(){
        if (canRangedWeaponAttack(player))
            creature.rangedWeaponAttack(player);
        else if (canThrowAt(player))
            creature.throwItem(getWeaponToThrow(), player.x, player.y, player.z);
        else if (creature.canSee(player.x, player.y, player.z))
            hunt(player);
        else if (canPickup())
            creature.pickup();
        else
            wander();
    }
    public void hunt(Creature target){
        List<Point> points = new Path(creature, target.x, target.y).points();

        int mx = points.get(0).x - creature.x;
        int my = points.get(0).y - creature.y;

        creature.moveBy(mx, my, 0);
    }

    private boolean canRangedWeaponAttack(Creature other){
        return creature.weapon() != null
                && creature.weapon().rangedAttackValue() > 0
                && creature.canSee(other.x, other.y, other.z);
    }

    private boolean canThrowAt(Creature other) {
        return creature.canSee(other.x, other.y, other.z)
                && getWeaponToThrow() != null;
    }

    private Item getWeaponToThrow() {
        Item toThrow = null;

        for (Item item : creature.inventory().getItems()){
            if (item == null || creature.weapon() == item || creature.armor() == item)
                continue;

            if (toThrow == null || item.thrownAttackValue() > toThrow.attackValue())
                toThrow = item;
        }

        return toThrow;
    }

    private boolean canPickup() {
        return creature.item(creature.x, creature.y, creature.z) != null
                && !creature.inventory().isFull();
    }

    protected boolean canUseBetterEquipment() {
        int currentWeaponRating = creature.weapon() == null ? 0 : creature.weapon().attackValue() + creature.weapon().rangedAttackValue();
        int currentArmorRating = creature.armor() == null ? 0 : creature.armor().defenseValue();

        for (Item item : creature.inventory().getItems()){
            if (item == null)
                continue;

            boolean isArmor = item.attackValue() + item.rangedAttackValue() < item.defenseValue();

            if (item.attackValue() + item.rangedAttackValue() > currentWeaponRating
                    || isArmor && item.defenseValue() > currentArmorRating)
                return true;
        }

        return false;
    }


    protected void useBetterEquipment() {
        int currentWeaponRating = creature.weapon() == null ? 0 : creature.weapon().attackValue() + creature.weapon().rangedAttackValue();
        int currentArmorRating = creature.armor() == null ? 0 : creature.armor().defenseValue();

        for (Item item : creature.inventory().getItems()){
            if (item == null)
                continue;

            boolean isArmor = item.attackValue() + item.rangedAttackValue() < item.defenseValue();

            if (item.attackValue() + item.rangedAttackValue() > currentWeaponRating
                    || isArmor && item.defenseValue() > currentArmorRating) {
                creature.equip(item);
            }
        }
    }

}