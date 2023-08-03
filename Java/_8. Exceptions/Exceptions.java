import java.util.ArrayList;

public class Exceptions {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hola Mundo");
        myList.add(48);
        myList.add("Adios Mundo");

        for (int i = 0; i < myList.size(); i++) {
            try {
                int castedValue = (int) myList.get(i);
                System.out.println("El valor en el índice " + i + " es: " + castedValue);
            } catch (ClassCastException e) {
                System.out.println("Error de casting en el índice " + i + ". Valor: " + myList.get(i));
                System.out.println("Mensaje de error: " + e.getMessage());
            }
        }
    }
}
