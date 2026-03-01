package Object;

import java.time.LocalDate;
import java.util.UUID;

public class Task {

    private static int counter = 1;

    String name;
    String status;
    int number;
    UUID id;
    LocalDate date;

    public Task(String name, String status) {
        this.name = name;
        this.status = status;
        this.number = counter;
        counter++;
        this.id = UUID.randomUUID();
        this.date = LocalDate.now();
    }

    //getters
    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task: Number-" + number + "; Name-" + name + "; Status-" + status + "; Date-" + date;
    }
}
