import java.util.ArrayList;

public class BasicJava {
    public static void main(String[] args) {
        //* 1)
        imprimir1A255();
        //* 2)
        imprimirImpar1A255();
        //* 3)
        imprimirSuma();
        //* 4)
        int[] nums1 = {1, 3, 5, 7, 9, 13};
        recorrerArreglo(nums1);
        //* 5)
        int[] nums2 = {-3, -5, -7};
        System.out.println(encontrarMaximo(nums2));
        //* 6)
        int[] nums3 = {2, 10, 3};
        System.out.println(obtenerPromedio(nums3));
        //* 7)
        System.out.println(arregloImpares());
    }

    static void imprimir1A255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    static void imprimirImpar1A255() {
        for (int i = 1; i <= 255; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    static void imprimirSuma() {
        int sum = 0;
        for (int i = 0; i <= 255; i++) {
            sum += i;
            System.out.println("Nuevo numero: " + i + " Suma: " + sum);
        }
    }

    static void recorrerArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static int encontrarMaximo(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static String obtenerPromedio(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return "Promedio de " + (double) sum / arr.length;
    }

    static ArrayList<Integer> arregloImpares() {
        ArrayList<Integer> impares = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 == 1) {
                impares.add(i);
            }
        }
        return impares;
    }
}
