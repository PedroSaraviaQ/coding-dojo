public class HumanTest {
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human();

        human1.attack(human2);
        human1.attack(human2);
        human1.attack(human2);

        System.out.println(human1.getHealth());
        System.out.println(human2.getHealth());

        human2.attack(human1);
        human2.attack(human1);

        System.out.println(human1.getHealth());
        System.out.println(human2.getHealth());
    }
}
