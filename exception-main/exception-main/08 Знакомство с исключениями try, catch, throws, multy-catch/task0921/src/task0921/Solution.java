package task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
Написать программу, которая будет вводить числа с клавиатуры.
Код по чтению чисел с клавиатуры должен быть в методе readData.
Код внутри readData обернуть в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа, то метод должен перехватить исключение и вывести на экран все ранее введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода.


Requirements:
1. Программа должна считывать данные с клавиатуры.
2. Метод main не изменять.
3. Метод main не должен кидать исключений.
4. Метод readData должен содержать блок try..catch.
5. Если пользователь ввел текст, а не число, программа должна вывести все ранее введенные числа.*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integers = new ArrayList<>();
        try {
            while (true) {
                integers.add(Integer.parseInt(reader.readLine()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число");
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода");
        }
        finally {
            System.out.println("Введенные числа");
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }

        //напишите тут ваш код
    }
}
