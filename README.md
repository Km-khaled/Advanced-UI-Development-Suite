# Advanced UI Development Suite

## Overview
This repository showcases a collection of user interface (UI) projects demonstrating proficiency in both desktop and web-based application development. It features Java-based games, calculators (simple, binary, and scientific++)implementations, and an interactive web drawing tool.

## Projects

### 1. XO Game (Tic-Tac-Toe)
A classic two-player game was implemented using JavaFX and following the Model-View-Controller (MVC) architecture.

**Key Features:**
- Interactive game board
- Player name input
- Score tracking
- Game state management

**Technologies:** Java, JavaFX, FXML

### 2. Minesweeper
A Java Swing implementation of the classic Minesweeper game.

**Key Features:**
- Customizable grid size
- Difficulty levels
- Timer and mine counter

**Technologies:** Java, Swing

### 3. Calculator Variants
Multiple calculator implementations showcasing different UI concepts and design patterns.

**Key Features:**
- Basic arithmetic operations
- binary operations
- Scientific functions (in advanced version)
- Responsive layouts

**Technologies:** Java, Swing/JavaFX

### 4. Web-based Drawing Tool
An interactive drawing application built with web technologies.

**Key Features:**
- Free-hand drawing
- Shape tools (rectangle, circle, triangle)
- Color picker
- Image upload and editing
- Save Functionality

**Technologies:** HTML5, CSS3, JavaScript, Canvas API

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 
- JavaFX SDK (for XO Game)
- Web browser with HTML5 support (for Drawing Tool)

### Installation
1. Clone the repository:
   ```
   git clone https://github.com/Km-khaled/Advanced-UI-Development-Suite
   ```
2. Navigate to the project directory:
   ```
   cd Advanced-UI-Development-Suite
   ```
3. Compile the Java projects:
   ```
   javac -d bin src/**/*.java
   ```

### Running the Projects
- **XO Game:** `java -cp bin TicTacToe.Main`
- **Minesweeper:** `java -cp bin Minesweeper.Main`
- **Calculators:** `java -cp bin Calculator.Main`
- **Web Drawing Tool:** Open `index.html` in your web browser

## Contributing
Contributions to improve the projects or add new features are welcome. Please follow these steps:
1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Make your changes and commit (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a new Pull Request

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments
- JavaFX Community
- HTML5 Canvas contributors
- Open-source UI framework developers
