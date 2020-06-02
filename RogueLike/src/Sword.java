public class Sword extends Equipment{
    private int damage;

    public Sword(int damage, String name, int weight){
        this.damage = damage;
        this.name = name;
        this.weight = weight;
    }

    public int getDamage() {
        return damage;
    }

    public void displayEquipmentStats(){
        System.out.println("Sword :");
        System.out.println("- Damage = " + this.damage);
        System.out.println("- Name = " + this.name);
        System.out.println("- Weight = " + this.weight);
        System.out.println("-----------------------------------");
    }
}
