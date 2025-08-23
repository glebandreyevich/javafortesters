package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {
    @Test
    void ArrayTests(){
        //var array = new String[]{"a","b","c"};
        var array = new String[3];
        array[0]="a";
        Assertions.assertEquals(3,array.length);
        Assertions.assertEquals("a", array[0]);
        array[0]= "d";
        Assertions.assertEquals("d", array[0]);

    }
    @Test
    void listTests (){
        var list = new ArrayList<String>(List.of("a","b","c"));
        Assertions.assertEquals(3,list.size());
        Assertions.assertEquals("a",list.get(0));
        list.set(0,"d");
        Assertions.assertEquals("d",list.get(0));

    }

}
