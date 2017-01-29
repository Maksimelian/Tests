package package1;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPhoneBook {

    PhoneBook book = new PhoneBook();

    @Test
    public void testFindPhoneNumber_notFound() {
        assertNotNull("Не найден существующий объект", book.findPhoneNumber("Сидоров С.С."));
    }

    @Test
    public void testFindPhoneNumber_mismatch() {

        ArrayList<String> array = new ArrayList<String>();
        array.add("+8 800 2000 800");
        array.add("+8 800 2000 900");
        array.add("+8 800 2000 000");

        assertEquals("Тестовый объект не совпадает с полученным",array,book.findPhoneNumber("Сидоров С.С."));
    }

    @Test
    public void testFindPhoneNumber_notExistFound() {

        assertNull("Найден несуществующий объект",book.findPhoneNumber("####OOOO"));

    }

}