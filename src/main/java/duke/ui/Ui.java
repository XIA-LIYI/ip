package duke.ui;

import duke.support.Login;
import duke.task.Task;
import duke.task.TaskList;
import duke.user.User;

import java.util.Random;

/**
 * Ui deals with interactions with the user.
 */
public class Ui {
    public static void showLine(String msg) {
        System.out.println(msg);
    }

    public static String bye() {
        return "See you again!";
    }

    public static String addTask(Task task, TaskList taskList) {
        return "Got it. I've added this task:\n" + task.toString() + "\nNow you have "
                + taskList.size() + " tasks in the list.";
    }

    public static String getTasks(TaskList taskList) {
        int num = 1;
        String res = "Here are the tasks in your list:\n";
        for (Task task: taskList.getList()) {
            res += (num + "." + task.toString() + "\n");
            num++;
        }
        return res;
    }

    public static String doneTask(Task task) {
        return "Nice! I've marked this task as done:\n" + task.toString();
    }

    public static String deleteTask(Task task, TaskList taskList) {
        return "Noted. I've removed this task:\n" + task.toString()
                + "\nNow you have " + taskList.size() + " tasks in the list.";
    }

    public static String setTaskTag(int taskIndex, String oldTag, String newTag) {
        if (oldTag == null) {
            return "Noted. I've tagged Task " + taskIndex + " as " + newTag + ".";
        } else {
            return "Noted. I've tagged Task " + taskIndex + " as " + newTag + ". Its original tag is " + oldTag + ".";
        }
    }

    public static String login() {
        if (Login.isLogined()) {
            User user = Login.getUser();
            return "Hi, " + user.getNickname() + "! Long time no see.";
        } else {
            return "Invalid username or password. Please try again.";
        }
    }

    public static String accessMissing() {
        return "No Access for Command. Please login in first.";
    }

    public static String addUser() {
        return "A new user has been added successfully.";
    }

    public static String love() {
        String[] reply;
        reply = new String[]{
                "����Ŷ��", "���㣡", "ÿ�춼�к�����Ŷ��", "���������ڸ��", "��������������ȥ���߰ɣ�", "�������?", "�²����жమ�㣡",
                "ɵ�ӣ����ʲô��û��!", "����������ô��ѽ��", "�Է�û����Ҳ��ԣ�", "Love you!", "Good Good Study, Day Day Up",
                "It is lucky to have you!", "Pig!", "Beauty", "Are you with me ?", "Take a photo to record the life~",
                "When I first saw you, I thought you were a pig!", "LMAO, nothing here!", "�㻹�ڵ����", "����¶���ʱ�������ס������",
                "Nothing deserves my love except you.", "���¾��ã��������ȣ�", "���������������"
        };
        Random random = new Random();

        int index = random.nextInt(reply.length);
        return reply[index];
    }
}
