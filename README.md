# Todo Console App

A simple console-based TODO application written in Java, using SQLite for task storage.

## Features

- Create tasks with a name and status (`In Progress` / `Complete`)  
- View all tasks  
- Update task name and status  
- Delete tasks  
- All data is stored in a SQLite database (`todo.db`)

## Project Structure

```
todo-console/
├─ lib/             # Java source code
├─ todo/src/       # SQLite database
├─ .gitignore
└─ README.md
```

## Usage

1. Clone the repository:

```bash
git clone https://github.com/username/todo-console.git
```

2. Open the project in IntelliJ IDEA or another Java IDE  
3. Run `Main.java`  

- On the first run, the database and `tasks` table will be created automatically.  
- After that, you can create, view, update, and delete tasks.  

## Requirements

- Java JDK 17+  
- SQLite JDBC library (`sqlite-jdbc`)

## License

You can add a license later, e.g., MIT.
