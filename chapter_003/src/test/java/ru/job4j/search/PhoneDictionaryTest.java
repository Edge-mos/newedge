package ru.job4j.search;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 04.04.2018.
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary dictionary = new PhoneDictionary();
        dictionary.add(new Person("test", "test", "12345", "testCity"));
        dictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> personList = dictionary.find("Petr");
        assertThat(personList.iterator().next().getSurname(), is("Arsentev"));
    }
}
