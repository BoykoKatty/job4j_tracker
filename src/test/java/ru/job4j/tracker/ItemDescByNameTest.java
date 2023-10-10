package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void whenSortDescDECAB() {
        Item item1 = new Item("Aa");
        Item item2 = new Item("Bb");
        Item item3 = new Item("Cc");
        Item item4 = new Item("Dd");
        Item item5 = new Item("Ee");
        List<Item> items = Arrays.asList(item4, item2, item3, item1, item5);
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(Arrays.asList(item5, item4, item3, item2, item1));
    }
}