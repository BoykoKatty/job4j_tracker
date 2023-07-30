package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        Item item = new Item(input.askStr("Enter name: "));
        out.println(tracker.replace(id, item) ? "Заявка изменена успешно." : "Ошибка замены заявки.");
        return true;
    }
}
