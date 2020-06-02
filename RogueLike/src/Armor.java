public class Armor extends Equipment{
    private int defence;

    public Armor(int defence, String name, int weight){
        this.defence = defence;
        this.name = name;
        this.weight = weight;
    }

    public void displayEquipmentStats(){
        System.out.println("Armor :");
        System.out.println("- defence = " + this.defence);
        System.out.println("- Name = " + this.name);
        System.out.println("- Weight = " + this.weight);
        System.out.println("-----------------------------------");
    }
}
