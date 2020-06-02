public class Character {
    private String name;
    private int life;
    private Inventory inventory;

    public Character(String name, int life){
        this.name = name;
        this.life = life;
        this.inventory = new Inventory();
    }

    public void addEquipmentFromInventory(Equipment e){
        this.inventory.addEquipment(e);
    }

    public void removeEquipmentFromInventory(Equipment e){
        this.inventory.removeEquipment(e);
    }

    public void takeDamage(int damage){
        this.life -= damage;
        if(life <= 0){
            System.out.println(this.name + " is dead");
        }
    }

    public void attack(Character c){
        int damage = this.inventory.getDamageValue();
        c.takeDamage(damage);
    }

    public void displayCharacterStats(){
        System.out.println("Character :");
        System.out.println("- Name = " + this.name);
        System.out.println("- Life = " + this.life);
        System.out.println("-----------------------------------");
    }
}
