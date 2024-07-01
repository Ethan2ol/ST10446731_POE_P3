import javax.swing.JOptionPane;
class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskHours;
    private String taskStatus;
    private String taskID;

    public boolean checkTaskDescription(String description) {
        if (description.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Task successfully captured.");
            return true;
        }
    }

    public String createTaskID() {
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastThreeChar = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return initials + ":" + taskNumber + ":" + lastThreeChar;
    }

    public String printTaskDetails() {
        String details = "Task Status: " + taskStatus + "\n";
        details += "Developer Details: " + developerDetails + "\n";
        details += "Task Number: " + taskNumber + "\n";
        details += "Task Name: " + taskName + "\n";
        details += "Task Description: " + taskDescription + "\n";
        details += "Task ID: " + taskID + "\n";
        details += "Task Hours: " + taskHours + "\n";
        details += "Total Hours:" + TaskFeatureTest.totalHours + "\n";
        return details;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public int getTaskHours() {
        return taskHours;
    }

    public void setTaskHours(int taskHours) {
        this.taskHours = taskHours;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
}