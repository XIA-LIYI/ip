package duke.task;

import java.util.ArrayList;

/**
 * TaskList contains the task list e.g.,
 * it has operations to add/delete tasks in the list.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public void remove(int index) {
        taskList.remove(index);
    }

    public Task get(int index) {
        return taskList.get(index);
    }

    public int size() {
        return taskList.size();
    }

    public ArrayList<Task> getList() {
        return taskList;
    }

    public TaskList find(String condition) {
        ArrayList<Task> newTaskList = new ArrayList<Task>();
        taskList.stream()
                .filter(x->x.getContent().contains(condition) || x.getTag().contains(condition))
                .forEach(x->newTaskList.add(x));
        return new TaskList(newTaskList);
    }
}