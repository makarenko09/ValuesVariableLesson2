package skypro;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        int intVariable = 1234567810;
        byte byteVariable = 12;
        short shortVariable = 12345;
        long longVariable = (long) (intVariable * Math.pow(10, 9));
        float aFloat = 18.34f;
        float bFloat = 0.062f;
        float floatVariable = aFloat / bFloat; // Explicit type casting
        Random rand = new Random();
        double doubleVariable = rand.nextDouble() * 1.7976931348623157E305 / 4.653419E-4;
        if (Double.MAX_VALUE < doubleVariable) {
            doubleVariable = Double.MAX_VALUE;
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
                );
                // Handle the user's selection
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
        ArrayList<String> list = new ArrayList<>();
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
        // вывод чисел
        String[] stringArr = list.toArray(new String[0]);
        // Типы переменных в массиве
        ArrayList<Long> longNumbers = new ArrayList<>();
        ArrayList<Double> doubleNumbers = new ArrayList<>();

        for (String num : stringArr) {
            System.out.println("До обработки: " + num);
            String cleanedNum = num.replace(" ", "").replace(",", ".");
            try {
                long longValue = Long.parseLong(cleanedNum);
                longNumbers.add(longValue);
                System.out.println("Целое число, с типом , с типом long, равно: " + longValue);
            } catch (NumberFormatException e) {
                try {
                    double doubleValue = Double.parseDouble(cleanedNum);
                    doubleNumbers.add(doubleValue);
                    System.out.println("Число с плавающей точкой, с типом double, равно: " + doubleValue);
                } catch (NumberFormatException e2) {
                    System.out.println("Значение '" + num + "' не может быть преобразовано в число. Пропущено.");
                }
            }
        }
        System.out.println("Double numbers: " + doubleNumbers);
        System.out.println("Long numbers: " + longNumbers);

        System.out.println("Execute exercise number 2");

        int[] teachers = {23, 27, 30};
        int sumStudents = Arrays.stream(teachers).sum();
        int papers = 480;
        int paperForStudent = papers / sumStudents;
        System.out.println("На каждого ученика рассчитано " + paperForStudent + " листов бумаги");

        System.out.println("Execute exercise number 3");

        int num = 20;
        int productionPer2Minutes = 16;
        long productionPerHour = productionPer2Minutes * 30;
        System.out.println("For " + num + " minutes, the machine will produce: " + (productionPerHour * num / 60) + " units");
        System.out.println("In a day, the machine will produce: " + productionPerHour * 24 + " units");
        System.out.println("In 3 days, the machine will produce: " + (productionPerHour * 72) + " units");
        System.out.println("In a month (30 days), the machine will produce: " + ((productionPerHour * 24) * 30) + " units");

        System.out.println("Execute exercise number 4");

        short maxCup = 120;
        byte maxC = 4;
        byte maxW = 2;
        int maxCupForClass = maxW + maxC;
        int maxClass = maxCup / maxCupForClass;
        int needWhitePaint = maxW * maxClass;
        int needBrownPaint = maxC * maxClass;

        System.out.println("In a school with " + maxClass + " classes, you need " + needWhitePaint + " cans of white paint and " + needBrownPaint + " cans of brown paint");

        System.out.println("Execute exercise number 5");

        int[] eatVolume = {80, 105, 100, 700};
        int[] eatEtem = {5, 2, 2, 1};
        int[] result = new int[eatVolume.length];

        for (int i = 0; i < eatVolume.length; i++) {
            result[i] = eatVolume[i] * eatEtem[i];
            System.out.println("Результат для элемента " + i + ": " + result[i]);
        }

        int gram = Arrays.stream(result).sum();
        double kilo = (double) Math.floorDiv(gram, 1000) + (double) Math.floorMod(gram, 1000) / 1000;

        System.out.println("Вес в килограммах: " + kilo + "\nВес в граммах: " + gram);

        System.out.println("Execute exercise number 6");
    }
}
