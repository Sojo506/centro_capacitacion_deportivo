# Depor&T

A Java-based application for managing a sports training center, including athletes, routines, invoices, parents, sports, and users. The project uses SQL for data persistence and Ant for build automation.

## Features

- Athlete, Parent, and User management
- Routine and Sport tracking
- Invoice generation and management
- Secure password handling
- Modular DAO architecture

## Project Structure

- `app/` — Application entry point
- `controller/` — Business logic controllers
- `dao/` — Data access objects (DAOs) and implementations
- `db/` — Database connection utilities
- `model/` — Entity classes
- `resources/` — SQL schema and resources
- `util/` — Utility classes
- `view/` — (Reserved for UI components)

## Technologies

- Java
- SQL (see `resources/scheme.sql`)
- Apache Ant

## Setup

1. **Clone the repository:**

2. **Configure the database:**
   - Set up your SQL database using the schema in `resources/scheme.sql`.
   - Update database connection settings in `db/ConnectionDB.java` if needed.

3. **Build the project:**
4. **Run the application:**
  

## Contributing

Pull requests are welcome. For major changes, please open an issue first.

## License

This project is for educational purposes.
