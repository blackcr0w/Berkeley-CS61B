public class testingFox extends testingAnimal{
    String name;
    public testingFox() {
    }
    public testingFox(String s) {
        name = s;
        System.out.println(name);
    }
    public void speak() {
        System.out.println("Ringding");
    }
}