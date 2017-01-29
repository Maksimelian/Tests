package package1;

import java.util.ArrayList;
import java.util.HashMap;


public class PhoneBook {

    private HashMap<String,ArrayList<String>> book= new HashMap<String,ArrayList<String>>();

    public PhoneBook(){

        ArrayList<String> array = new ArrayList<String>();
        array.add("+8 800 2000 500");
        array.add("+8 800 200 600");
        book.put("Иванов И.И.".toUpperCase(),array);

        array = new ArrayList<String>();
        array.add("+8 800 2000 700");
        book.put("Петров П.П.".toUpperCase(),array);

        array = new ArrayList<String>();
        array.add("+8 800 2000 800");
        array.add("+8 800 2000 900");
        array.add("+8 800 2000 000");
        book.put("Сидоров С.С.".toUpperCase(),array);
    }

    public ArrayList<String> findPhoneNumber(String name){
        if (book.containsKey(name.toUpperCase())){
            return  book.get(name.toUpperCase());
        }else{
            return null;
        }
    }
}
