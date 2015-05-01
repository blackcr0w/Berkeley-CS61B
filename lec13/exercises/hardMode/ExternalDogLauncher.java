import ug.joshh.animal.Dog;
/** 
 *  @author Josh Hug
 */

public class ExternalDogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog("frankie", "barnacle dog", 22);
        System.out.println(d.toString());
    }
} 