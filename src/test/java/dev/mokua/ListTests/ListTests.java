package dev.mokua.ListTests;

import dev.mokua.utilities.ArrayList;
import dev.mokua.utilities.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListTests {

    @Test
    void add_items_size() {
        List<String> names = new ArrayList();
        names.add("Brian");
        names.add("Smith");
        names.add("Collin");
        Assertions.assertEquals(3, names.size());
    }

    @Test
    void get_by_index() {
        List<String> names2 = new ArrayList();
        names2.add("Brian");
        names2.add("Smith");
        names2.add("Collin");
        String result = names2.get(1);
        Assertions.assertEquals("Smith", result);

    }


}

