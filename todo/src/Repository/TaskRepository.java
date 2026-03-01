package Repository;

import DBConnection.DatabaseConnection;
import Object.Task;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository {

    public static List<Task> getAllTasksAsList() {

        List<Task> todos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tasks")) {

            while (rs.next()) {
                Task task = new Task(
                        rs.getString("name"),
                        rs.getString("status")
                );
                task.setNumber(rs.getInt("number"));
                task.setId(UUID.fromString(rs.getString("id")));
                task.setDate(LocalDate.parse(rs.getString("date")));
                todos.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public static void getAllTasks() {

        try (Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tasks")) {

            boolean hasTasks = false;

            while (rs.next()) {

                hasTasks = true;

                int number = rs.getInt("number");
                String name = rs.getString("name");
                String status = rs.getString("status");
                String date = rs.getString("date");
                String id = rs.getString("id");

                System.out.println(number + " | " + name + " | " + status + " | " + date);
            }

            if (!hasTasks) {
                System.out.println("No tasks!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTask(Task newTask) {

        String sql = """
                INSERT INTO tasks(id, number, name, status, date) VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTask.getId().toString());
            pstmt.setInt(2, newTask.getNumber());
            pstmt.setString(3, newTask.getName());
            pstmt.setString(4, newTask.getStatus());
            pstmt.setString(5, newTask.getDate().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTask(Task newTask) {

        String sql = """
                UPDATE tasks SET name = ?, status = ? WHERE id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTask.getName());
            pstmt.setString(2, newTask.getStatus());
            pstmt.setString(3, newTask.getId().toString());
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Task has been updated");
            } else {
                System.out.println("Task with such number does not exist!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTask(Task newTask) {

        String sql = """
                DELETE from tasks WHERE id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTask.getId().toString());
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Task has been deleted!");
            } else {
                System.out.println("Task with such ID does not exist!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
