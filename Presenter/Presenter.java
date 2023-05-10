package Homework.IVP_JAVA_HW_Lessone003.Presenter;

import Homework.IVP_JAVA_HW_Lessone003.Console.View;
import Homework.IVP_JAVA_HW_Lessone003.Model.DataPerson;
import Homework.IVP_JAVA_HW_Lessone003.Model.SaveData;

public class Presenter {

    public void pb() {

        DataPerson dp = new DataPerson();
        View v = new View();
        SaveData sd = new SaveData();

        dp.setSurname(); // Ввод фамилии
        
        dp.setName(); // Ввод имени

        dp.setPatronymic(); // Ввод отчества
        
        dp.setDateOfBirth(); // Ввод даты рождения

        dp.setGender(); // Ввод пола

        dp.setTelephone(); // Ввод телефона

        System.out.printf("Фамилия: %s, Имя: %s, Отчество: %s, Дата рождения: %s,"+ 
        "Пол: %s, Телефон: %d\n\n", dp.getSurname(),dp.getName(),dp.getPatronymic(),
        dp.getDateOfBirth(),dp.getGender(),dp.getTelephone());

        String text = "Для сохранения данных введите y+Enter."+
        "\nДля выхода без сохранения любой символ и, или Enter.";
        String saveData = v.inputValueStr(text);

        if(saveData.equals("y")){
            sd.saveData(dp.getName(),dp.getPatronymic(),dp.getSurname(),dp.getDateOfBirth(),dp.getTelephone(),dp.getGender());
        }
        
    }
    
}
