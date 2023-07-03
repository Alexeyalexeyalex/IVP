/* 1) Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

2) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то 
оповестить пользователя.

3) (Дополнительно) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо 
как-то оповестить пользователя.*/

public class DZ1 {

    public static void main(String args[]) {
        // 1
        //int num = errorType(); // Присвоение переменной значение неправильного типа
        //int num = errorSint(); // Синтаксическая ошибка при написании кода
        //error(); // Выход за пределы массива
        

        //2
        int[] resultArray = diffArr(new int[] {1,2,3}, new int[] {3,2,10});
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
        System.out.println();
        //3
        resultArray = quotient(new int[] {1,2,3}, new int[] {3,2,10});
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }




    // 1) Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    // Выход за пределы массива
    private static void error(){
        int[] arr = {0,1,2,3};
        int num = arr[10];
    }

    // Синтаксическая ошибка при написании кода
    public static int errorSint(){
        int num = 3;
        num = 4
        return num;
    }

    // Присвоение переменной значение неправильного типа
    public static int errorType(){
        int num = 3;
        num = "Hello";
        return num;
    }


    /* 2) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
    каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то 
    оповестить пользователя. */
    
    private static int[] diffArr(int[] arr1, int[] arr2){
        checkArrayLen(arr1, arr2);
        int[] diff = arr1;
        for (int i = 0; i < diff.length; i++) {
            if (arr1[i]>arr2[i]){
                diff[i] =  arr1[i] - arr2[i];
            }
            else{
                diff[i] =  arr2[i] - arr1[i];
            }
        }
        return diff;
    }

 

    /*Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
    каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, 
    необходимо как-то оповестить пользователя*/


    private static int[] quotient(int[] arr1, int[] arr2){
        checkArrayLen(arr1, arr2);
        int[] quotient = arr1;
        for (int i = 0; i < quotient.length; i++) {
            if (arr1[i]>arr2[i]){
                quotient[i] =  arr1[i] / arr2[i];
            }
            else{
                quotient[i] =  arr2[i] / arr1[i];
            }
        }
        return quotient;
    }
    public static void checkArrayLen(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 != len2) {
            throw new RuntimeException(String.format("Длинна массивов не совпадает первый - [%d]   второй - [%d]", len1, len2));
        }
    }

}