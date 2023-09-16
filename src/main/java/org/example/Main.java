package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//@SpringBootApplication
public class Main {

    public static void main(String[] args) {
//        SpringApplication.run(Main.class,args);
//        System.out.println("Натисніть Ctrl+C (або Cmd+C на macOS), щоб завершити програму.");

        int mark = 0;
        List<MathExample> mathDigitList = new ArrayList<>();
        Random random = new Random();
        int numberOfElements = random.nextInt(4,10);

        while (mathDigitList.size() < numberOfElements) {
            int firstDigit = random.nextInt(10) + 1; // Від 1 до 10
            int secondDigit = random.nextInt(10) + 1; // Від 1 до 10

            boolean isUnique = true;
            for (MathExample mathDigit : mathDigitList) {
                if (mathDigit.getFirstDigit() == firstDigit && mathDigit.getSecondDigit() == secondDigit) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                MathExample mathDigit = new MathExample(firstDigit, secondDigit);
                mathDigitList.add(mathDigit);
            }
        }
        Scanner scanner = new Scanner(System.in);

        for (MathExample mathDigit : mathDigitList) {
            System.out.println("FirstDigit: " + mathDigit.getFirstDigit() + ", SecondDigit: " + mathDigit.getSecondDigit());
            System.out.print("Введіть результат: ");

            if (scanner.hasNextInt()) {
                int intValue = scanner.nextInt();
                if(intValue == mathDigit.getFirstDigit() * mathDigit.getSecondDigit())
                {
                    mark++;
                }
            }
        }
        System.out.println("Введено " + mark + " правильних відповідей з " + numberOfElements + " питань");
        System.out.println("Оцінка " + (mark*12)/numberOfElements);

    }
}