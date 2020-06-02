import java.util.HashSet;
import java.util.Iterator;

public class Inventory {
    private HashSet<Equipment> listEquipment;

    public Inventory(){
        this.listEquipment = new HashSet<Equipment>();
    }

    public void addEquipment(Equipment e){
        this.listEquipment.add(e);
    }

    public void removeEquipment(Equipment e){
        this.listEquipment.remove(e);
    }

    public void displayListEquipment(){
        Iterator<Equipment> i = this.listEquipment.iterator();
        while (i.hasNext()){
            i.next().displayEquipmentStats();
        }
    }

    public int getDamageValue(){
        int damage = 0;
        Iterator<Equipment> i = this.listEquipment.iterator();
        while (i.hasNext()){
            Equipment e = i.next();
            if(e instanceof Sword){
                damage = ((Sword) e).getDamage();
            }
        }
        return damage;
    }
}
