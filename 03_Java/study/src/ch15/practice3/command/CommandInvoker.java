package ch15.practice3.command;

import java.util.ArrayList;

public class CommandInvoker {
    ArrayList<Command> commands = new ArrayList<>();

    public void execute (int choice) {
        commands.get(choice).execute();
    }

    public void register (int index, Command command) {
        commands.add(index - 1, command);
    }
}
