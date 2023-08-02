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

    @Test
    public void whenFindActionById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Searched item"));
        Input in = new StubInput("0", String.valueOf(item.getId()), "1");
        Output output = new StubOutput();
        UserAction[] actions = {
                new FindActionById(output),
                new ExitProgram(output)
        };
        new StartUI().init(in, output, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindActionsByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Searched item"));
        Input in = new StubInput("0", item.getName(), "1");
        Output output = new StubOutput();
        UserAction[] actions = {
                new FindActionsByName(output),
                new ExitProgram(output)
        };
        new StartUI().init(in, output, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenShowAllActions() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput("0", "1");
        Output output = new StubOutput();
        UserAction[] actions = {
                new ShowAllActions(output),
                new ExitProgram(output)
        };
        new StartUI().init(in, output, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput("0", String.valueOf(one.getId()), replaceName, "1");
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new ExitProgram(out)
        };
        new StartUI().init(in, out, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput("1", "0");
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitProgram(out)
        };
        new StartUI().init(in, out, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }
}