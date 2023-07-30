package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput("0", "Item name", "1");
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitProgram(output)
        };
        new StartUI().init(in, output, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput("0", String.valueOf(item.getId()), replacedName, "1");
        Output output = new StubOutput();
        UserAction[] actions = {
                new EditAction(output),
                new ExitProgram(output)
        };
        new StartUI().init(in, output, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput("0", String.valueOf(item.getId()), "1");
        Output output = new StubOutput();
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitProgram(output)
        };
        new StartUI().init(in, output, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}