package skypro;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int intVariable = 123456781;
        byte byteVariable = 12;
        short shortVariable = 12345;
        long longVariable = (long) (intVariable * Math.pow(10, 9));
        float aFloat = 18.34f;
        float bFloat = 0.062f;
        float floatVariable = aFloat / bFloat; // Explicit type casting
        Random rand = new Random();
        double doubleVariable = (double) rand.nextDouble() * 1.7976931348623157E305 / 4.653419E-4;
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
                        "Значение переменной MaxDoubleValue, с типом double, равно " + Double.MAX_VALUE + "\n" +
                        "Значение переменной charVariable, с типом char, равно " + charVariable + "\n" +
                        "Значение переменной booleanVariable, с типом boolean, равно " + booleanVariable
        );

        System.out.println("Execute exercise number 1");
        // add variables to .txt
        String fileName = "data.txt"; // File name to save the data
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
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
            while (selected != 0) {
                // Handle the user's selection
                if (selected == 0) {
                    System.out.println("Выбрано 'Продолжить'");
                } else if (selected == 1) {
                    System.out.println("Выбрано 'Закончить'");
                } else if (selected == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Окно было закрыто без выбора");
                }
                String text = JOptionPane.showInputDialog(null, "Введите сообщение:");
                System.out.println("Получено сообщение : " + text);
                if (text != null) { // Check if text is not null
                    writer.println(text);
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
        // вывод чисел в массив строк
        String[] stringArr = list.toArray(new String[0]);
//        мы создали новый массив строк и поместили в него содержимое списка list.
        List<Long> longNumbers = new ArrayList<>();
        List<Double> doubleNumbers = new ArrayList<>();
        List<Float> floatNumbers = new ArrayList<>();
        List<Short> shortNumbers = new ArrayList<>();
        List<Integer> intNumbers = new ArrayList<>();
        List<Byte> byteNumbers = new ArrayList<>();
        List<String> errorValues = new ArrayList<>();

        for (String num : stringArr) {
            System.out.println("До обработки: " + num);
//            String num = num.replace("", ""); // Удаляем только пробелы
            try {
                // Проверяем на наличие суффиксов 'L' и 'f'
                if (num.endsWith("L")) {
                    // Убираем суффикс и парсим как long
                    long longValue = Long.parseLong(num.substring(0, num.length() - 1));
                    longNumbers.add(longValue);
                    System.out.println("Число типа long: " + longValue + "L");
                } else if (num.endsWith("f")) {
                    float floatValue = Float.parseFloat(num.substring(0, num.length() - 1));
                    floatNumbers.add(floatValue);
                    System.out.println("Число типа float: " + floatValue + "f");
                }
            } catch (NumberFormatException e) {
                long parsedLong = Long.parseLong(num);
                if (parsedLong >= Byte.MIN_VALUE && parsedLong <= Byte.MAX_VALUE) {
                    byteNumbers.add((byte) parsedLong);
                    System.out.println("Число типа byte: " + parsedLong);
                }
                if (parsedLong >= Short.MIN_VALUE && parsedLong <= Short.MAX_VALUE) {
                    shortNumbers.add((short) parsedLong);
                    System.out.println("Число типа short: " + parsedLong);
                }
                if (parsedLong >= Integer.MIN_VALUE && parsedLong <= Integer.MAX_VALUE) {
                    intNumbers.add((int) parsedLong);
                    System.out.println("Число типа int: " + parsedLong);
                }
                longNumbers.add(parsedLong);
                System.out.println("Число типа long: " + num + "L");


                try {
                    var parsedDouble = Double.parseDouble(num);
                    if (parsedDouble >= -Double.MAX_VALUE && parsedDouble <= Double.MAX_VALUE) {
                        doubleNumbers.add(parsedDouble);
                        System.out.println("Число типа double: " + parsedDouble);
                    }
                } catch (NumberFormatException e2) {
                    // Добавляем некорректное значение в список ошибок
                    errorValues.add(num);
                    System.out.println("Значение '" + num + "' не может быть преобразовано в число.");
                }
            }
        }
        // Выводим результаты
        System.out.println("Byte numbers: " + byteNumbers);
        System.out.println("Short numbers: " + shortNumbers);
        System.out.println("Int numbers: " + intNumbers);
        System.out.println("Long numbers: " + longNumbers);
        System.out.println("Float numbers: " + floatNumbers);
        System.out.println("Double numbers: " + doubleNumbers);
        // Выводим ошибки
        System.out.println("Не удалось преобразовать следующие значения: " + errorValues);

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
        int unitsIntTwentyMinutes = (int) (productionPerHour * num / 2);
        int unitsInOneDay = (int) (productionPerHour * 24);
        int unitsInThreeDay = (int) (productionPerHour * 72);
        System.out.println("For " + num + " minutes, the machine will produce: " + unitsIntTwentyMinutes + " units");
        System.out.println("In a day, the machine will produce: " + unitsInOneDay + " units");
        System.out.println("In 3 days, the machine will produce: " + unitsInThreeDay + " units");

        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue(); // Месяц от 1 до 12
        System.out.println("Current Month: " + currentMonth);
        // Получаем количество дней в текущем месяце
        YearMonth yearMonth = YearMonth.of(currentDate.getYear(), currentMonth);
        int daysInMonth = yearMonth.lengthOfMonth();
        System.out.println("Number of days in the current month: " + daysInMonth);
        // Calculate production for the entire month
        long productionPerMonth = (productionPerHour * 24) * daysInMonth;
        System.out.println("In a month (" + daysInMonth + " days), the machine will produce: " + productionPerMonth + " units");

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

        int totalWeightToLose = 7 * 1000; // кг в г
        int weightLossPerDayMin = 250; // г
        int weightLossPerDayMax = 500; // г
        // Расчет дней для минимальной и максимальной потери веса
        int daysMin = (totalWeightToLose + weightLossPerDayMin - 1) / weightLossPerDayMin;
        int daysMax = (totalWeightToLose + weightLossPerDayMax - 1) / weightLossPerDayMax;
        // Calculate the average number of days
        double averageDays = (daysMin + daysMax) / 2.0;
        // Output the results
        System.out.println("При потере 250 грамм в день потребуется " + daysMin + " дней.");
        System.out.println("При потере 500 грамм в день потребуется " + daysMax + " дней.");
        System.out.println("В среднем может потребоваться " + averageDays + " дней.");

        System.out.println("Execute exercise number 7");

        byte experience = 3;
        int[] salary = {67760, 83690, 76230};
        double[] upSalaries = new double[salary.length];
        int[] annualDifference = new int[salary.length];
//        double upSalary = (double) Math.multiplyExact(salary, 110) + (double) Math.floorDiv(salary, 100) + (double) Math.floorMod(salary, 100) / 100;
        for (int i = 0; i < salary.length; i++) {
            upSalaries[i]= (double) Math.multiplyExact(salary[i], 110) / 100;
            System.out.println("Up salary for " + i + ": " + upSalaries[i]);

            // Расчет годового дохода до и после повышения
            int annualCurrent = salary[i] * 12;
            int annualIncreased = (int) (upSalaries[i] * 12);

            // Разница между годовым доходом после повышения и текущим годовым доходом
            annualDifference[i] = annualIncreased - annualCurrent;
            System.out.println("Annual difference for employee " + i + ": " + annualDifference[i]);
        }
        System.out.println("Маша теперь получает " + upSalaries[0] + " рублей. Годовой доход вырос на " + annualDifference[0] + " рублей.");
        System.out.println("Денис теперь получает " + upSalaries[1] + " рублей. Годовой доход вырос на " + annualDifference[1] + " рублей.");
        System.out.println("Кристина теперь получает " + upSalaries[2] + " рублей. Годовой доход вырос на " + annualDifference[2] + " рублей.");
        System.out.println("Execute exercise number 8");
    }
}
