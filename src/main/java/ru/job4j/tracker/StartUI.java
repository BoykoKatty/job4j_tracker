package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Output output, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions, output);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                output.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions, Output output) {
        output.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
           output.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllActions(output),
                new EditAction(output),
                new DeleteAction(output),
                new FindActionById(output),
                new FindActionsByName(output),
                new ExitProgram(output),
        };
        new StartUI().init(input, output, tracker, actions);
        input.closeResource();
    }
}