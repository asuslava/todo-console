package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Object.Task;
import Repository.TaskRepository;
import Validator.Validator;

public class TaskService {

    List<Task> todos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void createTodo() {

        String name = Validator.readString(scanner);
        String status = statusMethod();

        Task newTask = new Task(name, status);

        TaskRepository.addTask(newTask);
        todos = TaskRepository.getAllTasksAsList();
        System.out.println("Task has been created!");

    }

    public void showTodos() {
        TaskRepository.getAllTasks();
    }

    public void updateTodo() {

        boolean isValid = true;

        List<Task> todos = TaskRepository.getAllTasksAsList();

        while (isValid) {

            int numberOfTheTask = Validator.wrongInputAndRange(todos, scanner);

            Task taskToChange = todos.get(numberOfTheTask-1);
            System.out.println("Change: 1 - name, 2 - status, 3 - do not change");
            int change = Validator.readInt(scanner);

            switch (change) {
                case 1:
                    String newName = Validator.readString(scanner);
                    taskToChange.setName(newName);
                    TaskRepository.updateTask(taskToChange);
                    isValid = false;
                    break;
                case 2:
                    taskToChange.setStatus(statusMethod());
                    TaskRepository.updateTask(taskToChange);
                    isValid = false;
                    break;
                case 3:
                    System.out.println("Nothing has been changed!");
                    isValid = false;
                    break;
            }
            TaskRepository.getAllTasks();
        }
    }

    public void deleteTodo() {

        List<Task> todos = TaskRepository.getAllTasksAsList();

        int numberOfTheTask = Validator.wrongInputAndRange(todos, scanner);

        Task taskToDelete = todos.get(numberOfTheTask-1);

        TaskRepository.deleteTask(taskToDelete);

        todos.remove(numberOfTheTask-1);
    }

    public String statusMethod() {
        System.out.println("Choose status: 1 - In Progress, 2 - Complete:");
        int statusChoice = Validator.readInt(scanner);

        String status = "";

        switch (statusChoice) {
            case 1:
                status = "In Progress";
                break;
            case 2:
                status = "Complete";
                break;
        }
        return status;
    }
}
