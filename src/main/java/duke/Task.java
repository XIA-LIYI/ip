package duke;
import duke.exceptions.DukeException;

public class Task {
    private boolean isDone;
    private String taskContent;

    public Task(String taskContent) {
        this.taskContent = taskContent;
        this.isDone = false;
    }
    public void markAsDone() {
        this.isDone = true;
    }
    public void test() throws DukeException {
        if (taskContent.length() == 0) {
            throw new DukeException("OOPS!!! The description of a task cannot be empty.");
        }
    }
    public String getType() {
        return "";
    }
    public boolean isDone() {
        return this.isDone;
    }
    public String getContent() {
        return this.taskContent;
    }
    public String getDate() {
        return "";
    }
    @Override
    public String toString() {
        if (isDone) {
            return "[" + "\u2713" + "] " + this.taskContent;
        } else {
            return "[" + "\u2718" + "] " + this.taskContent;
        }
    }
}
