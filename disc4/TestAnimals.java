public class TestAnimals {
	public static void main(String[] args){
		Animal a = new Animal("Pluto", 10);
		Cat c = new Cat("Garfield", 6);
		Dog d = new Dog("Fido", 4);

		a.greet(); // Animal Pluto says: Huh?
		c.greet(); // Cat Garfield says: Meow!
		d.greet(); // Dog Fido says: "WOOF!"

		a = c;
		a.greet(); // Cat Garfield says: Meow!
		((Cat) a).greet(); // Cat Garfield says: Meow!

		a = new Dog("Hieronymus", 10);
		d = (Dog) a;
	}
}