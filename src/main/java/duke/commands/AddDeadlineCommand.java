package duke.commands;

import java.time.LocalDate;

import duke.Deadline;
import duke.Storage;
import duke.Task;
import duke.TaskList;
import duke.Ui;

public class AddDeadlineCommand extends Command {
    private String commandContent;

    public AddDeadlineCommand(String commandContent) {
        this.commandContent = commandContent;
    }

    public String run(TaskList taskList, Storage storage) {
        Task newTask;
        int index = commandContent.indexOf('/');
        String taskContent = commandContent.substring(0, index - 1);
        String dateString = commandContent.substring(index + 4);
        try {
            LocalDate taskDeadline = LocalDate.parse(dateString);
            newTask = new Deadline(taskContent, taskDeadline);
        } catch (Exception e) {
            newTask = new Deadline(taskContent, dateString);
        }
        taskList.add(newTask);
        return Ui.addTask(newTask, taskList);
    }

}
