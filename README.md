# Dynamic-Data-Visualizations

# Data Structures and Algorithms Implementation

## Overview

This project provides comprehensive implementations of fundamental data structures and algorithms in Java, focusing on key concepts such as sorting, searching, and graph traversal. The goal is to create a resource that facilitates learning and serves as a reference for students and developers alike.

## Table of Contents

1. [Data Structures](#data-structures)
2. [Algorithms](#algorithms)
3. [Technologies Used](#technologies-used)
4. [Features](#features)
5. [Getting Started](#getting-started)
6. [Contributing](#contributing)
7. [License](#license)
8. [Acknowledgments](#acknowledgments)

## Data Structures

### Bubble Sort
- **Description:** Implementation of the bubble sort algorithm, a simple sorting technique that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
- **Key Methods:**
  - `bubbleSort(int[] arr)`: Sorts the given array in ascending order.

### Binary Search Tree (BST)
- **Description:** A binary tree data structure that maintains sorted data, allowing for efficient insertion, search, and traversal operations.
- **Key Methods:**
  - `insert(int value)`: Inserts a new value into the BST.
  - `search(int value)`: Searches for a value in the BST.
  - `inOrderTraversal()`: Returns elements in sorted order.

### Graph
- **Description:** Implementation of an undirected graph using an adjacency list. Supports both Depth-First Search (DFS) and Breadth-First Search (BFS) traversal algorithms.
- **Key Methods:**
  - `addEdge(int src, int dest)`: Adds an edge between two vertices.
  - `DFS(int start)`: Performs depth-first traversal starting from a given vertex.
  - `BFS(int start)`: Performs breadth-first traversal starting from a given vertex.

### Min Heap
- **Description:** A binary heap where the parent node is less than or equal to its children, implemented using Java's `PriorityQueue`.
- **Key Methods:**
  - `insert(int value)`: Inserts a value into the min heap.
  - `extractMin()`: Removes and returns the minimum element.

### Stack
- **Description:** Implementation of a simple stack data structure using Java's built-in `Stack` class, supporting LIFO (Last In, First Out) operations.
- **Key Methods:**
  - `push(int value)`: Pushes a new value onto the stack.
  - `pop()`: Removes the top value from the stack.
  - `peek()`: Returns the top value without removing it.

## Algorithms

### Fibonacci
- **Description:** A recursive implementation of the Fibonacci sequence that computes the nth Fibonacci number.
- **Key Method:**
  - `fibonacci(int n)`: Returns the nth Fibonacci number.

### Knapsack Problem
- **Description:** A dynamic programming approach to solve the 0/1 knapsack problem, which determines the maximum value that can be carried in a knapsack of a given capacity.
- **Key Method:**
  - `knapsack(int[] weights, int[] values, int capacity)`: Computes the maximum value for the given weights and values.

## Technologies Used

- **Java 8:** The primary programming language used for implementation, known for its object-oriented features and robust libraries.
- **Java Collections Framework:** Utilized extensively for data structure implementations, providing efficient storage and manipulation of collections of data.

## Features

- **Well-Documented Code:** Each class and method is documented with clear comments explaining its purpose and functionality.
- **Comprehensive Test Cases:** Each data structure and algorithm includes test cases to verify correctness and efficiency.
- **Efficient Implementations:** Algorithms are optimized for performance, ensuring they run efficiently even with larger data sets.

## Getting Started

To get started with this project, follow these steps:

1. **Clone the Repository:**
   Use the following command to clone the repository to your local machine:
   ```bash
   git clone https://github.com/your-username/data-structures-algorithms.git
