package Homework.IVP_JAVA_HW_Lessone003.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {

    public void saveData(String name, String patronymic, String surname, String dateOfBirth,
            Long i, String gender) {

        //String address = "C:/Users/SBB2-Ермилов Артём/YandexDisk-artyomermiloff/GeegBrains/Programming/Java/Homework/IVP_JAVA_HW_Lessone003/";
        String address = "IVP_JAVA_HW_Lessone003/";
        String folder = "Base/";
        String nameFile = surname + ".txt";
        String fullAddress = address + folder + nameFile;

        StringBuilder builder = new StringBuilder();
        builder.append("Фамилия: ");
        builder.append(surname);
        builder.append(", Имя: ");
        builder.append(name);
        if (!patronymic.equals("")) {
            builder.append(", Отчество: ");
            builder.append(patronymic);
        }        
        builder.append(", Дата рождения: ");
        builder.append(dateOfBirth);
        builder.append(", Телефон: ");
        builder.append(i);
        builder.append(", Пол: ");
        builder.append(gender);
        builder.toString();

        File file = new File(fullAddress);
       

        try (FileWriter fw = new FileWriter(fullAddress, true)) {
            fw.append(builder.toString() + "\n");
           
            fw.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
