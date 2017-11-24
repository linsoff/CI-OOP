package medvedstudio.sandbox.ci.lab9.tests;

import medvedstudio.sandbox.ci.lab9.src.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.AccessException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {

    private LinkedList<Person> list;

    @BeforeEach
    public void initTest() {

        list = new LinkedList<>();
    }

    @Test
    public void add() {

        //Prepare
        assertEquals(0, list.length());
        assertTrue(list.isEmpty());
        assertFalse(list.isFilled());


        //Initialization
        Person first = new Person("Test", 1);
        Person begin = new Person("New", 2);
        Person rangeElement = new Person("range", 3);
        Person insert = new Person("insert", 4);


        //Processing
        list.add(first);
        list.addToBegin(begin);

        ArrayList<Person> range = new ArrayList<>();
        range.add(rangeElement);
        list.add(range);

        list.insert(insert, 100);
        list.insert(insert, -3);
        assertEquals(3, list.length());
        list.insert(insert, 1);


        //Check
        assertEquals(0, list.indexOf(begin));
        assertEquals(1, list.indexOf(insert));
        assertEquals(2, list.indexOf(first));
        assertEquals(3, list.indexOf(rangeElement));

        assertEquals(begin, list.first());
        assertEquals(rangeElement, list.last());

        assertEquals(4, list.length());
        assertFalse(list.isEmpty());
        assertTrue(list.isFilled());
    }

    @Test
    public void remove() {

        //Initializations
        for (int i = 0; i < 10; i++) {
            list.add(new Person(((Integer) i).toString(), i));
        }
        assertEquals(10, list.length());


        //Processing
        //First
        list.removeFirst();
        assertEquals(1, list.first().id);
        assertEquals(9, list.length());

        //Last
        list.removeLast();
        assertEquals(8, list.last().id);
        assertEquals(8, list.length());

        //Remove by reference
        list.remove(list.first());
        assertEquals(2, list.first().id);
        assertEquals(7, list.length());

        //Remove by index
        assertEquals(5, list.find(3).id);
        list.remove(3);
        assertEquals(6, list.find(3).id);
        assertEquals(6, list.length());

        //Remove all
        list.removeAll();
        assertTrue(list.isEmpty());
    }

    @Test
    public void find() {

        //Initializations
        for (int i = 0; i < 10; i++) {
            list.add(new Person(((Integer) i).toString(), i));
        }
        assertEquals(10, list.length());


        //Processing
        //Find
        assertNull(list.find(-1));
        assertNull(list.find(112));
        assertEquals(list.first().id, list.find(0).id);
        assertEquals(list.last().id, list.find(9).id);

        //Index Of
        assertEquals(-1, list.indexOf(new Person("", 0)));
        Person finded = list.find(6);
        assertEquals(6, list.indexOf(finded));

        //First
        finded = list.first((element) -> element.id == 14);
        assertNull(finded);
        finded = list.first((element) -> element.id % 2 == 1);
        assertEquals(list.find(1), finded);

        //Filter
        Iterable<Person> range = list.filter((element) -> element.id == 1231);
        assertNotNull(range);
        range = list.filter((element) -> element.id > 5);
        assertNotNull(range);
        for (Person element : range) {
            assertTrue(element.id > 5);
        }

        //Iterator
        int count = 0;
        for (Person element : new LinkedList<>(list)) {
            assertEquals(count, element.id);
            count++;
        }
        assertEquals(list.length(), count);


        //Check
        assertEquals(10, list.length());
    }


    private class Person {

        public String name;
        public int id;

        public Person(String name, int id) {

            this.name = name;
            this.id = id;
        }
    }
}
