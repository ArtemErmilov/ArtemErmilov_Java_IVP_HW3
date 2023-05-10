package Homework.IVP_JAVA_HW_Lessone003.Console;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class View {

    // --------------------- Ввод данных в консоль--------------------------//

    private Scanner scannerStr;

    /**
     * Ввод данных в формате String
     * 
     * @param text - текст для вывода в консоль
     * @return
     */

    public String inputValueStr(String text) {
        String dataStr = null;
        try {
            Scanner scannerStr = new Scanner(System.in, "Cp866");
            System.out.print(text);
            dataStr = scannerStr.nextLine();
            // scannerStr.close();
            return dataStr;
        } catch (NoSuchElementException e) {

        }
        return dataStr;
    }

    /**
     * Ввод данных в формате String, но не пустое.
     * 
     * @param text - текст для вывода в консоль
     * @return
     */

    public String inputValueStrNoNull(String text) {
        String dataStr = null;
        while (true) {
            try {
                Scanner scannerStr = new Scanner(System.in, "Cp866");
                System.out.print(text);
                dataStr = scannerStr.nextLine(); 
                if (dataStr.length() < 1) {
                    System.out.println("Данные не введены, введите их заново!");
                    continue;
                } else {
                    //scannerStr.close();
                    return dataStr;
                }
            } catch (NoSuchElementException | NullPointerException e) {
                
            } 
        }

    }

    /**
     * Ввод данных в формате Integer
     * 
     * @param text - текст для вывода в консоль
     * @return
     */

    public Integer inputValueInt(String text) {
        while (true) {
            try {
                System.out.print(text);
                Scanner scannerInt = new Scanner(System.in);
                Integer dataInt = scannerInt.nextInt();
                scannerInt.close();
                return dataInt;
            } catch (InputMismatchException e) {
                System.out.println("Данные не соответствуют формату Integer, введите данные правильно.");
            }

        }
    }

}
