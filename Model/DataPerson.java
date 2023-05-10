package Homework.IVP_JAVA_HW_Lessone003.Model;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Homework.IVP_JAVA_HW_Lessone003.Console.View;

public class DataPerson {
    /**
     * Метод ввода и вывода данных человека.
     */

    View vive = new View(); // Метод ввода/вывода данных.

    String name;
    String patronymic;
    String surname;

    long telephone;

    String gender;

    String dateOfBirth;

    private Integer date(String dateIn) {
        /*
         * Проверка даты.
         * Ошибки 1 - месяц больше 12.
         */
        
        Integer highYear = 2024;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String todayDate = LocalDateTime.now().format(formatter);

        
        dateIn = dateIn.replace(".", "#");
        todayDate = todayDate.replace(".", "#");

        String[] dateInArr = dateIn.split("#");
        String[] todayDateArr = todayDate.split("#");

        Integer dateInD = Integer.parseInt(dateInArr[0]);
        Integer dateInM = Integer.parseInt(dateInArr[1]);
        Integer dateInY = Integer.parseInt(dateInArr[2]);

        Integer todayDateD = Integer.parseInt(todayDateArr[0]);
        Integer todayDateM = Integer.parseInt(todayDateArr[1]);
        Integer todayDateY = Integer.parseInt(todayDateArr[2]);

        Boolean dateBooM20 = (dateInM == 1 || dateInM == 3 || dateInM == 5 || dateInM == 7 || dateInM == 8 ||
                dateInM == 10 || dateInM == 12) && dateInD > 31;
        Boolean dateBooM21 = (dateInM == 4 || dateInM == 6 || dateInM == 9 || dateInM == 11) && dateInD > 30;
        Boolean dateBooM22 = (dateInM == 2 && (highYear - dateInY) % 4 == 0 && dateInD > 29);
        Boolean dateBooM23 = dateInM == 2 && (highYear - dateInY) % 4 != 0 && dateInD > 28;
        Boolean dateBooM30 = todayDateY < dateInY;
        Boolean dateBooM31 = todayDateM < dateInM && todayDateY.equals(dateInY);
        Boolean dateBooM32 = (todayDateY.equals(dateInY) && todayDateM.equals(dateInM)) && todayDateD < dateInD;

        
        if (dateInM > 12) { // Введёны месяц больше 12.
            return 1;

        } else if (dateBooM20 || dateBooM21 || dateBooM22 || dateBooM23) {
            return 2; // Количество дней в месяце превышает максимальное количество.

        } else if (dateBooM30 | dateBooM31 | dateBooM32) {
            return 3; // Введённая дата, больше сегодняшней даты!
        }

        return 0;

    }

    public void setName() { // Метод ввода имени.

        name = vive.inputValueStrNoNull("Введите Имя: ");

    }

    public void setPatronymic() { // Метод ввода отчества.

        patronymic = vive.inputValueStr("Введите Отчество: ");

    }

    public void setSurname() { // Метод ввода фамилии.

        surname = vive.inputValueStrNoNull("Введите Фамилию: ");

    }

    public void setGender() { // Метод ввода полового признака.

        while (true) {
            gender = vive.inputValueStrNoNull("f - женский пол, m - мужской пол. Введите пол: ");
            if (gender.equals("f") || gender.equals("F")
                    || gender.equals("m") || gender.equals("M")) {
                return;
            } else {
                System.out.println("Обозначение полового признака введено неправильно, введите его заново!");
                continue;
            }
        }

    }

    public void setTelephone() {
        /*
         * Метод ввода телефона. Длина номера должна быть не меньше 5-ти символов
         * и не больше 11 символов. Формат вывода 8-921-123-45-67 или 89211234567.
         */

        String textPrintTel = "Ввод номера телефона." +
                "\nДлина номера должна быть не меньше 5 символов и не больше 11" +
                "\nФормат ввода 5-55-55 или 55555" +
                "\nВведите номер телефона: ";
        String textAlarm = "\nТелефон введён не правильно, введите его заново!\n";

        while (true) {

            String newTelephone = vive.inputValueStrNoNull(textPrintTel);

            newTelephone = newTelephone.replace("-", "");

            try {
                telephone = Long.parseLong(newTelephone);

            } catch (NumberFormatException e) {
                System.out.println(textAlarm);
                continue;
            }
            if (newTelephone.length() >= 5 && 11 >= newTelephone.length()) {

                return;
            } else {
                System.out.println(textAlarm);
                continue;
            }
        }
    }

    public void setDateOfBirth() {

        /*
         * Метод ввода даты рождения в формате dd.mm.yyyy
         */

        String textPrintData = "Ввод даты рождения в формате dd.mm.yyyy\n" +
                "Введите дату рождения: ";

        while (true) {

            try {

                dateOfBirth = vive.inputValueStrNoNull(textPrintData);
                Date date = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);
                Integer alarms = date(dateOfBirth);
                if (alarms == 1) {
                    System.out.println("\nВведённый месяц больше 12! Введите дату заново!\n");
                    continue;
                } else if (alarms == 2) {
                    System.out.println(
                            "\nКоличество дней в месяце превышает максимальное количество! Введите дату заново!\n");
                    continue;
                } else if (alarms == 3) {
                    System.out.println("\nВведённая дата, больше сегодняшней даты! Введите дату заново!\n");
                    continue;
                } else {
                    return;
                }

            } catch (Exception e) {
                System.out.println("\nДата введена не правильно, введите её заново!\n");
                continue;
            }
        }

    }

    public String getName(){
        /*
         * Метод вывода имени.
         */
        return name;
    }

    public String getPatronymic(){
        /*
         * Метод вывода отчества.
         */
        return patronymic;
    }

    public String getSurname(){
        /*
         * Метод вывода фамилии.
         */
        return surname;
    }

    public String getGender(){
        /*
         * Метод вывода полового признака.
         */
        return gender;
    }


    public Long getTelephone() {
        /*
         * Метод вывода телефона.
         */

        return telephone;
    }

    public String getDateOfBirth() {
        /*
         * Метод вывода даты.
         */

        return dateOfBirth;
    }

}
