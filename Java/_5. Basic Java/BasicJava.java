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
        //* 8)
        int[] nums4 = {1, 3, 5, 7};
        System.out.println(mayorQue(nums4, 3));
        //* 9)
        int[] nums5 = {1, 5, 10, -2};
        System.out.println(valoresCuadrado(nums5));
        //* 10)
        int[] nums6 = {1, 5, 10, -2};
        System.out.println(numerosNegativos(nums6));
        //* 11)
        System.out.println(minimoMaximoPromedio(nums6));
        //* 12)
        int[] nums7 = {1, 5, 10, 7, -2};
        System.out.println(cambiarValoresArreglo(nums7));
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

    static int mayorQue(int[] arr, int Y) {
        int nums = 0;
        for (int element : arr) {
            if (element > Y) {
                nums++;
            }
        }
        return nums;
    }

    static ArrayList<Integer> valoresCuadrado(int[] arr) {
        ArrayList<Integer> cuadrados = new ArrayList<Integer>();
        for (int element : arr) {
            cuadrados.add(element * element);
        }
        return cuadrados;
    }

    static ArrayList<Integer> numerosNegativos(int[] arr) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                nums.add(arr[i]);
            } else {
                nums.add(0);
            }
        }
        return nums;
    }

    static ArrayList<Object> minimoMaximoPromedio(int[] arr) {
        ArrayList<Object> result = new ArrayList<Object>();
        int min = arr[0];
        int max = arr[0];
        int sum = 0;
        for (int element : arr) {
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
            sum += element;
        }
        result.add(min);
        result.add(max);
        result.add((double) sum / arr.length);
        return result;
    }

    static ArrayList<Integer> cambiarValoresArreglo(int[] arr) {
        ArrayList<Integer> new_arr = new ArrayList<Integer>();
        for (int i = 0; i < arr.length - 1; i++) {
            new_arr.add(arr[i + 1]);
        }
        new_arr.add(0);
        return new_arr;
    }
}
