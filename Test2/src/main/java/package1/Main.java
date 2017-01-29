package package1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)throws Exception{

        //при запуске программы ей можно передать кодировку в качесте параметра для правильной обработки строк
        String encoding = (args.length>0)?args[0]:"UTF-8";

        PhoneBook book = new PhoneBook();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in, encoding));
        }catch(UnsupportedEncodingException e){
            System.out.println("Неизвестная кодировка.");
            System.exit(1);
        }
        String str="";

        System.out.println("Введите ФИО для получения списка телефонов");
        str = reader.readLine();
        ArrayList<String> list = book.findPhoneNumber(str);
        if (list == null) System.out.println("Указанного человека нет в базе");
        else if(list.size() == 0) System.out.println("Для указанного человека в базе нет телефонных номеров");
        else {
            for(int i=0; i< list.size();i++){
                System.out.println( (i+1) + ": " + list.get(i));
            }
        }
    }
}
