import javax.swing.JOptionPane;
import java.util.ArrayList;

public class TaskFeature {
    public static int totalHours = 0;
    public static ArrayList<Task> taskList = new ArrayList<>();
    public static ArrayList<String> developerDetailsList = new ArrayList<>();

    public static void main(String[] args) {
        taskFeature();
    }

    public static void taskFeature() {
        int option;//Buttons for the Main Menu
        do {
            option = showOptionDialog();

            switch (option) {

                case 0:
                    addTasks();
                    break;

                case 1:
                    showTaskReport();
                    break;

                case 2:
                    showMessageDialog("Exiting Program");
                    break;
            }
        } while (option != 2);
    }

    public static int showOptionDialog() {
        String[] options = {"1. Add Tasks", "2. Show Report", "3. Quit"};//Naming the buttons
        return JOptionPane.showOptionDialog(
                null, "Select an option:", "Welcome To EasyKanban", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    public static void addTasks() {//Allowing to add tasks
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));

        for (int i = 1; i <= numTasks; i++) {
            Task task = new Task();

            String taskName = JOptionPane.showInputDialog("Please enter the Task Name:");
            task.setTaskName(taskName);

            int taskNumber = (int) (Math.random() * 1000);
            task.setTaskNumber(taskNumber);

            String taskDescription = JOptionPane.showInputDialog("Please enter the Task Description (max 50 characters):");
            while (!task.checkTaskDescription(taskDescription)) {
                taskDescription = showInputDialog("Please enter a task description of less than 50 characters:");
            }
            task.setTaskDescription(taskDescription);

            String developerDetails = JOptionPane.showInputDialog("Please enter Developer Details (First and Last Name):");
            task.setDeveloperDetails(developerDetails);
            developerDetailsList.add(developerDetails); // Add developerDetails to the list

            int taskHours = Integer.parseInt(JOptionPane.showInputDialog("How many hours will the task take?"));
            task.setTaskHours(taskHours);
            TaskFeature.totalHours += taskHours;

            String taskStatus = JOptionPane.showInputDialog("Task Status (please type out one of these options):\n1. To Do\n2. Doing\n3. Done");
            task.setTaskStatus(taskStatus);

            String taskID = task.createTaskID();
            task.setTaskID(taskID);

            taskList.add(task); // Add task to the task list

            showMessageDialog(task.printTaskDetails());
        }
    }

    public static void showTaskReport() {// Showing Reports
        String[] reportOptions = {"1. Show Tasks with Status 'Done'", "2. Developer with Longest Task", "3. Search Task by Name", "4. Tasks by Developer", "5. Delete Task by Name", "6. List All Tasks", "7. Quit"};
        int reportOption = JOptionPane.showOptionDialog(
                null, "Select a report option:", "Task Report Options", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, reportOptions, reportOptions[0]);

        switch (reportOption) {

            case 0:
                showTasksWithStatusDone();
                break;

            case 1:
                showDeveloperWithLongestTask();
                break;

            case 2:
                searchTaskByName();
                break;

            case 3:
                searchTasksByDeveloper();
                break;

            case 4:
                deleteTaskByName();
                break;

            case 5:
                listAllTasks();
                break;

            case 6:
                showMessageDialog("Exiting Report");
                break;

            default:
                showMessageDialog("Invalid Option");
                break;
        }
    }

    public static void showTasksWithStatusDone() {//Reports which are Done
        StringBuilder report = new StringBuilder();
        report.append("Tasks with Status 'Done':\n");
        for (Task task : taskList) {
            if ("Done".equalsIgnoreCase(task.getTaskStatus())) {
                report.append("Developer: ").append(task.getDeveloperDetails()).append("\n");
                report.append("Task Name: ").append(task.getTaskName()).append("\n");
                report.append("Task Duration: ").append(task.getTaskHours()).append(" hours\n\n");
            }
        }
        showMessageDialog(report.toString());
    }

    public static void showDeveloperWithLongestTask() {//Report that will that the longest
        Task longestTask = null;
        for (Task task : taskList) {
            if (longestTask == null || task.getTaskHours() > longestTask.getTaskHours()) {
                longestTask = task;
            }
        }
        if (longestTask != null) {
            String report = "Developer with Longest Task:\n";
            report += "Developer: " + longestTask.getDeveloperDetails() + "\n";
            report += "Task Duration: " + longestTask.getTaskHours() + " hours\n";
            showMessageDialog(report);
        } else {
            showMessageDialog("No tasks available.");
        }
    }

    public static void searchTaskByName() {//Search for a task by name
        String taskName = JOptionPane.showInputDialog("Enter the Task Name to search:");
        StringBuilder report = new StringBuilder();
        boolean found = false;
        for (Task task : taskList) {
            if (taskName.equalsIgnoreCase(task.getTaskName())) {
                report.append("Task Name: ").append(task.getTaskName()).append("\n");
                report.append("Developer: ").append(task.getDeveloperDetails()).append("\n");
                report.append("Task Status: ").append(task.getTaskStatus()).append("\n");
                found = true;
                break;
            }
        }
        if (!found) {
            report.append("No task found with the name '").append(taskName).append("'.");
        }
        showMessageDialog(report.toString());
    }

    public static void searchTasksByDeveloper() {// Searching for developers name
        String developerName = JOptionPane.showInputDialog("Enter the Developer Name to search tasks:");
        StringBuilder report = new StringBuilder();
        boolean found = false;
        for (Task task : taskList) {
            if (developerName.equalsIgnoreCase(task.getDeveloperDetails())) {
                report.append("Task Name: ").append(task.getTaskName()).append("\n");
                report.append("Task Status: ").append(task.getTaskStatus()).append("\n\n");
                found = true;
            }
        }
        if (found) {
            showMessageDialog("Tasks assigned to developer '" + developerName + "':\n" + report.toString());
        } else {
            showMessageDialog("No tasks assigned to developer '" + developerName + "'.");
        }
    }

    public static void deleteTaskByName() {//deleting tasks
        String taskName = JOptionPane.showInputDialog("Enter the Task Name to delete:");
        boolean found = false;
        for (Task task : taskList) {
            if (taskName.equalsIgnoreCase(task.getTaskName())) {
                taskList.remove(task);
                showMessageDialog("Task '" + taskName + "' deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            showMessageDialog("No task found with the name '" + taskName + "'.");
        }
    }

    public static void listAllTasks() {
        StringBuilder report = new StringBuilder();
        report.append("List of All Tasks:\n\n");
        for (Task task : taskList) {
            report.append(task.printTaskDetails()).append("\n");
        }
        showMessageDialog(report.toString());
    }

    public static void showDeveloperDetails() {
        StringBuilder report = new StringBuilder();
        report.append("Developer Details:\n");
        for (String developer : developerDetailsList) {
            report.append(developer).append("\n");
        }
        showMessageDialog(report.toString());
    }

    public static String showInputDialog(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    public static void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static int returnTotalHours() {
        return totalHours;
    }
}
