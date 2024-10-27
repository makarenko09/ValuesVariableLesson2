import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.FileReader;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int intVariable = 1234567810;
        byte byteVariable = 12;
        short shortVariable = 12345;
        long longVariable = (long) (intVariable * Math.pow(10, 9));
        long longVariable2 = 1234567891113151719L;
        float aFloat = 18.34f;
        float bFloat = 0.062f;
        float floatVariable = (float) (aFloat / bFloat); // Explicit type casting
        Random rand = new Random();
        double doubleVariable = rand.nextDouble() * 1.7976931348623157E305 / 4.653419E-4;
        if (+Double.MAX_VALUE < doubleVariable) {
            doubleVariable = +Double.MAX_VALUE;
            System.out.println("doubleVariable = MAX_VALUE");
        } else if (doubleVariable < Double.MIN_VALUE) {
            doubleVariable = Double.MIN_VALUE;
            System.out.println("doubleVariable = MIN_VALUE");
        }
        char charVariable = '@';
        boolean booleanVariable = true;

        System.out.println(
                "Значение переменной intVariable, с типом int, равно " + intVariable + "\n" +
                        "Значение переменной byteVariable, с типом byte, равно " + byteVariable + "\n" +
                        "Значение переменной shortVariable, с типом short, равно " + shortVariable + "\n" +
                        "Значение переменной longVariable, с типом long, равно " + longVariable + "\n" +
                        "Значение переменной floatVariable, с типом float, равно " + floatVariable + "\n" +
                        "Значение переменной doubleVariable, с типом double, равно " + doubleVariable + "\n" +
                        "Значение переменной charVariable, с типом char, равно " + charVariable + "\n" +
                        "Значение переменной booleanVariable, с типом boolean, равно " + booleanVariable
        );

        System.out.println("Execute exercise number 1");
// add variables to .txt
        String fileName = "data.txt"; // File name to save the data
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            while (true) {
                String text = JOptionPane.showInputDialog(null, "Введите сообщение:");
                System.out.println("Получено сообщение : " + text);
                if (text != null) { // Check if text is not null
                    writer.println(text);
                }

                Object[] options = {"Продолжить", "Закончить"};  // Show the dialog // Show the dialog
                int selected = JOptionPane.showOptionDialog(
                        null, // Parent component
                        "Выберите один из вариантов:", // Message
                        "Выбор", // Title
                        JOptionPane.DEFAULT_OPTION, // Option type (no predefined option type)
                        JOptionPane.QUESTION_MESSAGE, // Message type
                        null, // Icon
                        options, // Custom buttons
                        options // Initial value
                );  // Handle the user's selection
                if (selected == 0) {
                    System.out.println("Выбрано 'Продолжить'");
                } else if (selected == 1) {
                    System.out.println("Выбрано 'Закончить'");
                    break;
                } else if (selected == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Окно было закрыто без выбора");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        //Массив из файла txt
        ArrayList<String> list = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    list.add(str);
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        String[] stringArr = list.toArray(new String[0]);
        // Проверка тип переменных
        double[] doubleArr = Arrays.stream(stringArr)
                .mapToDouble(s -> {
                    try {
                        return Double.parseDouble(s);
                    } catch (NumberFormatException e) {
                        char anyElement = s.charAt(1);
                        System.out.println("Значение '" + s + "' не является числом. Тип: " + anyElement);
                        return Double.NaN; // Используем NaN для элементов, которые не могут быть преобразованы
                    }
                })
                .toArray();
        for (double value : doubleArr) {
            if (!Double.isNaN(value)) {
                System.out.println("Значение double: " + value);
            } else {
                System.out.println("Некорректное значение, пропущено.");
            }
        }

        System.out.println(Arrays.toString(doubleArr));


//        boolean isStringArray2 = stringArr instanceof String[];
//        if (isStringArray2) {
//            for (int i = 0; i < stringArr.length; i++) {
//                String element = stringArr[i];
//                System.out.println("Element " + (i + 1) + ": " + element);
//
//                try {
//                    double doubleElement = Double.parseDouble(element);
//                    System.out.println("Double element " + (i + 1) + ": " + doubleElement);
//                } catch (NumberFormatException e) {
//                    System.out.println("Element " + (i + 1) + " cannot be converted to double");
//                    char anyElement = element.charAt(1);
//                    System.out.println("Char element " + (i + 1) + ": " + anyElement);
//                }
//                }
//            }
    }


}
