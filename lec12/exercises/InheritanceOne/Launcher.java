/** 
 *  @author Josh Hug
 */

public class Launcher {
    public static void main(String[] args) {
        Animal a0 = new Animal();   // Line 1
        Fox f0 = new Fox();         // Line 2
        a0.speak();                 // Line 3 I'm an animal
        f0.speak();                 // Line 4 Ringding
        ((Animal) f0).speak();      // Line 5 Ringding
        // ((Fox) a0).speak();         // Line 6   Error 
        a0.staticSpeak();           // Line 7 Static animal
        ((Animal) f0).staticSpeak();// Line 8 Static animal
        f0.staticSpeak();           // Line 9 Do Barell Roll
        // ((Fox) a0).staticSpeak();   // Line 10 Error 
    }
} 