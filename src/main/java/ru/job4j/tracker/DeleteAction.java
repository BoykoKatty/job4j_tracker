package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        System.out.println(tracker.delete(id) ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
        return true;
    }
}
