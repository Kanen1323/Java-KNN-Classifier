# Project Documentation

## Introduction

This project implements a K-Nearest Neighbors (KNN) classifier, a popular algorithm used for classification tasks. The application provides functionalities for training the classifier with labeled data and then using it to classify new, unseen instances based on their similarity to the labeled instances.

## Classes

1. **Main**: Entry point of the application. It initializes the system panel and starts the classification process.

2. **Classification**: Represents a data point with its associated class label and distance. It includes methods for sorting instances based on distance and calculating distances between instances.

3. **Panel**: Core functionality of the KNN algorithm and interaction with users. It includes methods for instance classification, distance calculation, reading training data from files, user interaction, and performance evaluation.

## Singleton Design Pattern

The project utilizes the Singleton design pattern in the `Panel` class. The Singleton pattern ensures that only one instance of a class exists throughout the application's lifecycle. In this project, the `Panel` class is designed as a Singleton to ensure there's only one instance responsible for managing the KNN classifier and user interactions efficiently.

## Main Class (Main.java)

- **main Method**: Entry point of the application. It initializes the system panel and starts the classification process.

## Classification Class (Classification.java)

- **Constructor**: Initializes a Classification instance with given data and class type.
- **Methods**:
  - `getDany()`: Returns the data associated with the instance.
  - `getType()`: Returns the class type of the instance.
  - `getDistance()`: Returns the distance of the instance from a reference point.
  - `setDistance(double distance)`: Sets the distance of the instance from a reference point.
  - `sort(List<Classification> classifications)`: Sorts a list of Classification instances based on their distances.

## Panel Class (Panel.java)

- **Singleton Instance**: Implements the Singleton pattern to ensure only one instance of the Panel class is created.
- **Static Methods**:
  - `getInstance()`: Retrieves the singleton instance of the Panel class.
- **Public Methods**:
  - `start()`: Initiates the KNN classification process by interacting with the user, reading data, and performing classification.
  - `print_information(List<Classification> list)`: Prints information about the distribution of classes in a list of Classification instances.
  - `training_file(List<Classification> classifications)`: Reads training data from a file and populates a list of Classification instances.
  - `split(String my_data, List<Classification> classifications, int k, List<Classification> result, List<String> program_answer)`: Splits user-provided data and classifies it using KNN.
  - `procent(List<String> right_answer, List<String> program_answer)`: Calculates the percentage of correctly classified instances.

## Usage Instructions

1. Clone the repository to your local machine: 
[https://github.com/Kanen1323/Java-KNN-Classifier.git](https://github.com/Kanen1323/Java-KNN-Classifier.git)
2. Run the `Main` class.
3. Follow the instructions provided by the program to perform classification tasks:
   - Choose options to use a ready-made file or provide a file path for testing data.
   - Change the value of `k` for KNN classification.
   - Print information about the classification results and the percentage of correct classifications.

## Conclusion

This concludes the documentation for the KNN classifier project. The project employs the Singleton design pattern for the `Panel` class to ensure a single instance manages the classifier and user interactions efficiently. If you have any further questions or need assistance, feel free to ask!
