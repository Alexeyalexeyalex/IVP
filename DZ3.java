/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные, 
разделенные пробелом:
Фамилия Имя Отчество номертелефона

Форматы данных:
фамилия, имя, отчество - строки
номертелефона - целое беззнаковое число без форматирования

Ввод всех элементов через пробел

Приложение должно проверить введенные данные по количеству. 
Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и 
показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них 
требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, 
соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. 
Исключение должно быть корректно обработано, пользователю выведено сообщение с 
информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><номер_телефона>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно 
обработано, пользователь должен увидеть стектрейс ошибки.*/

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class DZ3 {
    public static void main(String[] args) {
        System.out.println("Введите Фамилия, Имя, Отчество, номер телефона через пробел:");
        Scanner scanner = new Scanner(System.in);
        String AllData = scanner.nextLine();
        scanner.close();
        
        Integer Number = null;
        String[] data = AllData.split(" ");
        String FirstName = "";
        String LastName = "";
        String OtchName = "";

        // преобразование строки в число
        try {
            FirstName = data[0];
            LastName = data[1];
            OtchName = data[2];
            Number = Integer.parseInt(data[3]);
        } catch (NumberFormatException e) {
            throw new ConvertExcept("Неправильный тип данных");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new OutOfArrayRange("Мало данных");
        }

        // запись в файл
        try {
            WriteFile(FirstName, LastName, OtchName, Number);
        } catch (WriteFileExcept e) {
              System.out.printf("%s : %s", e.getMessage());
        }
    }

    // запись файла
    public static void WriteFile(String F, String I, String O, Integer number) throws WriteFileExcept{

        String FilePath = F;
        FilePath = FilePath+".txt";
        try (FileWriter fileWriter = new FileWriter(FilePath, true)){
            fileWriter.write("<" + F + ">" + "<" + I + ">" + "<" + O + ">" + "<" + number + "> \n");
            
        } catch (Exception e) {
            throw new WriteFileExcept("Произошла ошибка при записи файла");
        }
    }
}


//  классы исключений
class ConvertExcept extends NumberFormatException{

    public ConvertExcept(String mess){
        super(mess);
    }
}

class OutOfArrayRange extends ArrayIndexOutOfBoundsException{

    public OutOfArrayRange(String mess){
        super(mess);
    }
}

class WriteFileExcept extends Exception{

    public WriteFileExcept(String mess){
        super(mess);
    }

}





