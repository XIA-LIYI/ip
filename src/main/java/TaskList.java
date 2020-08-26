import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> taskList;

    TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    void add(Task task) {
        taskList.add(task);
    }

    void remove(int index) {
        taskList.remove(index);
    }

    Task get(int index) {
    	return taskList.get(index);
    }

    int size() {
    	return taskList.size();
    }

    ArrayList<Task> getList() {
        return taskList;
    }

    ArrayList<Task> find(String condition) {
        ArrayList<Task> newTaskList = new ArrayList<Task>();
        for (Task task: taskList) {
            if (task.getContent().contains(condition)) {
                newTaskList.add(task);
            }
        }
        return newTaskList;
    }
}