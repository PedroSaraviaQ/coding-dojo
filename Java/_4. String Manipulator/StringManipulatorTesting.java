public class StringManipulatorTesting {
    public static void main(String[] args) {
        trimAndConcatTest();
        getIndexOrNullTest1();
        getIndexOrNullTest2();
        concatSubstringTest();
    }

    static void trimAndConcatTest() {
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hola     ", "     Mundo    ");
        System.out.println(str);
    }

    static void getIndexOrNullTest1() {
        StringManipulator manipulator = new StringManipulator();
        char letter = 'n';
        int a = manipulator.getIndexOrNull("Coding", letter);
        int b = manipulator.getIndexOrNull("Hola Mundo", letter);
        int c = manipulator.getIndexOrNull("Saludar", letter);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    static void getIndexOrNullTest2() {
        StringManipulator manipulator = new StringManipulator();
        String word = "Hola";
        String subString = "la";
        String notSubString = "mundo";
        int a = manipulator.getIndexOrNull(word, subString);
        int b = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(a);
        System.out.println(b);
    }

    static void concatSubstringTest() {
        StringManipulator manipulator = new StringManipulator();
        String word = manipulator.concatSubstring("Hola", 1, 3, "mundo");
        System.out.println(word);
    }
}
