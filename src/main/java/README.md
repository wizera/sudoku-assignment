
# Sudoku Assignment
A small assignment of soduku board generation.

* Generates a square sized board of 3x3 to 9x9 cells with given difficulty set as percentage and prints it to the console

* Shuffles rows and columns to maintain cell value validity for both rows and columns with the exception for 3x3 sub boards meaning that each 3x3 section may contain invalid values but each row and column are valid in the grand picture.

## Compiling / running the application

```bash
mvn clean package
java -Xmx32m -Xss256k -cp target/sudoku-0.0.1-SNAPSHOT.jar se.codeplay.hiq.assignment.sudoku.Main 4 50
```

## Arguments
The application supports two arguments to allow different board layouts
	1. Board size ( 3 - 9 )
	2. Difficulty ( 10 - 90 )
