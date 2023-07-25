import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public static void main(String[] args) {
        System.out.println(problem1());
        System.out.println(problem2());
        problem3();
    }

    static ArrayList<Integer> problem1() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> new_nums = new ArrayList<Integer>();
        int sum = 0;
        nums.add(3);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(7);
        nums.add(9);
        nums.add(8);
        nums.add(13);
        nums.add(25);
        nums.add(32);
        for (int num : nums) {
            if (num > 10) {
                new_nums.add(num);
            }
            sum += num;
        }
        System.out.println(sum);
        return new_nums;
    }

    static ArrayList<String> problem2() {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> new_names = new ArrayList<String>();
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        Collections.shuffle(names);
        for (String name : names) {
            System.out.println(name);
            if (name.length() > 5) {
                new_names.add(name);
            }
        }
        return new_names;
    }

    static void problem3() {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            alphabet.add((char) ('A' + i));
        }
        Collections.shuffle(alphabet);
        System.out.println("Last letter: " + alphabet.get(alphabet.size() - 1));
        char firstLetter = alphabet.get(0);
        System.out.println("First letter: " + firstLetter);
        //* Transform the variable to string and then checks if it's a vowel
        if ("AEIOU".contains(String.valueOf(firstLetter))) {
            System.out.println("It's a vowel!");
        }
    }
}
