# N-Puzzle Solver (UCS & A*) 🔲

This repository contains a Java-based solver for a modified version of the classic 8-puzzle. It demonstrates the application of Artificial Intelligence search algorithms, specifically Uniform Cost Search (UCS) and A* Search, to find the optimal path to a specific goal state.

**Academic Context:** 
This project was developed as the 1st Laboratory Exercise (Εργαστηριακή Άσκηση 1η) for the Artificial Intelligence (Τεχνητή Νοημοσύνη) course at the University of Ioannina (Πανεπιστήμιο Ιωαννίνων). It was completed under the instruction of Professor A. Lykas (Α. Λύκας). The development team consisted of Filippos Vezyris, Fotios Lisgaras, and Georgios Papageorgiou.

## ✨ Features & Game Rules

* **Goal State:** The algorithms attempt to reach a specific predefined configuration: `{1, 2, 3, 6, 5, 4, 7, 0, 8}`
* **Standard Moves:** Horizontal and vertical movements to an adjacent empty spot have a cost of 1.0.
* **Edge Moves:** Moving a tile from one edge of a row or column to the opposite edge (if the destination is empty) has a cost of 1.0.
* **Teleportation:** Moving a tile directly between the first index (0) and the last index (8) has a reduced cost of 0.5.

## 🧠 Algorithmic Approach

* **Uniform Cost Search (UCS):** Explores the state space strictly based on the path cost ($g$) without any heuristic guidance.
* **A* Search:** Utilizes both the path cost and an admissible heuristic function ($f = g + h$).
* **Heuristic Function:** The algorithm uses the "Misplaced Tiles" heuristic, multiplying the count of incorrectly placed tiles by 0.5. This heuristic is admissible because 0.5 represents the absolute minimum cost for any move (due to teleportation), ensuring it never overestimates the true cost of reaching the target.
* **Performance Comparison:** Experimental results show that while both UCS and A* find paths with the exact same total cost, A* requires significantly fewer state expansions, demonstrating much higher efficiency.

## 🛠️ Project Structure

* `Main.java`: The entry point that takes user input for the initial 9-element array and initiates the solving process for both UCS and A*.
* `PuzzleSolver.java`: Contains the core search algorithms (using a Priority Queue), move generation logic, and heuristic calculations.
* `State.java`: Represents a specific configuration of the board, tracking the path cost, heuristic value, and parent state for path reconstruction.
* `Action.java`: A helper class defining a move's target position and its associated cost.

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone [https://github.com/FILIPPOSVEZYRIS/N-Puzzle.git](https://github.com/FILIPPOSVEZYRIS/N-Puzzle.git)