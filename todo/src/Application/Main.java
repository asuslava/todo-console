package Application;

import java.util.Scanner;

import Repository.TaskRepository;
import Service.TaskService;
import Validator.Validator;
import DBConnection.DatabaseConnection;

public class Main {
    static void main(String[] args) {

        DatabaseConnection.createTable();
        TaskRepository.getAllTasks();

        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();
        boolean running = true;

        while (running) {
            System.out.println("\n1 - Show todos\n2 - Add todo\n3 - Update todo\n4 - Delete todo\n0 - Exit");
            int choice = Validator.readInt(scanner);

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    taskService.showTodos();
                    break;
                case 2:
                    taskService.createTodo();
                    break;
                case 3:
                    taskService.updateTodo();
                    break;
                case 4:
                    taskService.deleteTodo();
                    break;
            }
        }
    }
}