public class test {
	public static void main(String[] args){
		// testingAnimal a0 = new testingAnimal();
		// testingFox f0 = new testingFox();
		// // ((testingFox) a0).speak();         // Line 6
		// System.out.println(f0.name);
		// System.out.println(a0.name);

		// testingAnimal a1 = new testingFox();
		// a1.speak();
		// ((testingAnimal) a1).speak();


		// testingAnimal a2 = new testingAnimal();
		// System.out.println(a2.name);
		testingAnimal a3 = new testingFox("SuperFox");
		System.out.println(a3.name);
		System.out.println(((testingAnimal) a3).name);
	}
}