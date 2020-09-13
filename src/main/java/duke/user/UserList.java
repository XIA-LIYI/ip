package duke.user;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class UserList {
    private static File file;
    private static Path filepath;
    private static ArrayList<User> userList;

    public static void initialize() {
        String dir = System.getProperty("user.dir");
        Path path = Paths.get(dir, "duke", "userInfo.txt");
        filepath = path;
        File targetFile = path.toFile();
        if (targetFile.exists()) {
            file = targetFile;
        } else {
            try {
                targetFile.getParentFile().mkdirs();
                targetFile.createNewFile();
                file = targetFile;
                FileWriter writer = new FileWriter(file);
                String userInfo = "admin,password,dear\n";
                writer.write(userInfo);
                writer.close();
            } catch (IOException e) {
                System.out.println("Failed to create" + file.getAbsolutePath());
            }
        }
    }

    public static User check(User currentUser) {
        ArrayList<User> users = readUsersInfo();
        for (User user: users) {
            if (currentUser.isEqual(user)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> readUsersInfo() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String userContent = sc.nextLine();
                String[] userInfo = userContent.split(",", 3);
                User user = new User(userInfo[0], userInfo[1], userInfo[2]);
                users.add(user);
            }
            userList = users;
        } catch (Exception e) {
            System.out.println("Failed to load users information.");
        }
        return userList;
    }

    public static void addUser(User user) {
        try {
            FileWriter writer = new FileWriter(file);
            userList.add(user);
            write();
        } catch (IOException e) {
            System.out.println("Failed to add the new user.");
        }
    }

    public static void write() {
        try {
            FileWriter writer = new FileWriter(file);
            ArrayList<User> users = readUsersInfo();
            String usersInfo = "";
            for (User user: users) {
                usersInfo += (user.getUsername() + "," + user.getUserPassword() + "," + user.getNickname() + "\n");
            }
            writer.write(usersInfo);
            writer.close();

        } catch (IOException e) {
            System.out.println("Failed to write info int userInfo.txt");
        }
    }
}
