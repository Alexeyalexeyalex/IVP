/*
1) Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

2) Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

3) Дан следующий код, исправьте его там, где требуется (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

4) Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, 
что пустые строки вводить нельзя.
*/

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class DZ2 {
    public static void main(String[] args) {
        //div();
        CheckFloatFormat();
    }
    
    // 1
    public static void CheckFloatFormat(){
        Scanner scaner = new Scanner(System.in);
        int i =1;
        while (i<5) {
            try {
                float num = 0; 
                String strnum = scaner.nextLine();
                num = parseFloat(strnum);
                System.out.println(num);

            } catch (MyException e) {    
                System.out.printf(" \nСтрока - %s %s\n",  e.getX(), e.getMessage());
            }
            finally{
                i++;
            }
        }

    }

    public static float parseFloat(String num) throws MyException{
        try {
            if (num == "") {
                num = null;
            }
            return Float.valueOf(num);
        // 4
        }catch (NullPointerException e) {
            throw new MyException("пуста. Пустые строки вводить нельзя",num);
        }catch (NumberFormatException e) {
            throw new MyException("не является float",num);
        } 
        
    }
    
  

    // 2
    public static void div(){
        // try {
        //     int d = 0;
        //     double catchedRes1 = intArray[8] / d;
        //     System.out.println("catchedRes1 = " + catchedRes1);
        // } catch (ArithmeticException e) {
        //     System.out.println("Catching exception: " + e);
        // }
        

        try {
            int d = 0;
            int[] intArray = {0,1,2,3,4,5,6,7,8};
            double catchedRes1 = intArray[8] / d; // так понимаю не создан массив
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

}

class MyException extends Exception{
    private final String x;

    public MyException(String message, String x){
        super(message);
        this.x = x;
    }

    public String getX() {
        return x;
    }

}

