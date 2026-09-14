* Project Overview
- This project implements a functional and object-oriented approach to shape manipulation and rendering in Scala. It includes behaviors such as calculating bounding boxes, rendering shapes graphically, and scaling, sizing, and determining the height of shapes. The project uses the Doodle library for graphical rendering and integrates automated unit testing for all behaviors.

Questions and Work Created
- Question 1:
    You provided a compilation error log and asked for help fixing the errors in your Scala project.

    Work Created:
    Analyzed the errors and provided fixes for:
    Syntax errors (=> instead of = in pattern matching).
    Updated the syntax for Group(shapes*) in Scala 3.
    Resolved the Shape is already defined issue by removing duplicate definitions.

    Fixed:
    Fixed Not Found errors for variables like x1, y1, width, and height by correcting destructuring in pattern matching.
    Provided an updated boundingBox.scala file.
    
- Question 2:
    You ran sbt compile and provided another error log. You asked for help fixing the new errors.

    Work Created:

    Fixed:
    Missing commas in pattern matching for Rectangle(w, h).
    Cannot extend sealed class Shape in a different source file by ensuring all Shape cases were defined in the same file.
    Type mismatch errors by correcting the use of apply in shapes.map(apply).
    Provided updated Shape.scala and boundingBox.scala files.

- Question 3:
    You asked for help implementing graphical rendering of shapes using Doodle and automated unit testing of the draw behavior.

    Work Created:
    Added a draw method to the Shape enum using the Doodle library.
    Implemented offline rendering using BufferedImage for testing.
    Created a ShapeRenderer object to handle rendering shapes to images.
    Provided a TestDraw.scala file with unit tests for rendering shapes.
    
- Question 4:
    You asked how the files should be implemented within the directory structure.

    Work Created:

    Provided a detailed directory structure for the project.
    Explained where each file (Shape.scala, boundingBox.scala, draw.scala, TestDraw.scala, etc.) should be placed.

- Question 5:
    You ran sbt compile again and provided another error log. You asked for help fixing the new errors.

    Work Created:

    Fixed:
    Incorrect imports (doodle.syntax.all._ was unnecessary and removed).
    Removed derives CanEqual from Shape to fix type errors.
    Resolved ambiguous min and max errors by explicitly providing Ordering.Int.
    Corrected the use of on and at methods in the draw implementation.
    Provided updated Shape.scala and boundingBox.scala files.

- Question 6:
    You ran sbt test and provided another error log. You asked for help fixing the test failures.

    Work Created:

    Fixed the FileNotFoundException by ensuring the test-output/ directory was created before saving images.
    Updated TestDraw.scala to create the test-output/ directory programmatically.

- Question 7:
    You asked to combine TestDraw and TestFixtures.

    Work Created:

    Combined the test fixtures into TestDraw.scala by defining the shapes directly in the test file.
    Provided a new TestDraw.scala file with centralized test logic and fixtures.

- Question 8:
    You asked to keep TestFixtures separate and have TestDraw use it to create images.

    Work Created:

    Updated TestDraw.scala to import shapes from TestFixtures.
    Provided a new TestDraw.scala file that uses the predefined shapes from TestFixtures to generate images.

- Question 9:
    You asked for nonfunctional requirements:

    - Retain the original project structure.
    - Use functional/immutable code.
    - Create TestSize, TestHeight, and TestScale classes.
    - Use a logging library for debugging.

    Work Created:

    Retained the original project structure.
    Updated boundingBox.scala to use functional constructs like map, foldLeft, sum, min, and max.
    Created TestSize.scala, TestHeight.scala, and TestScale.scala with tests for size, height, and scale behaviors.
    Integrated slf4j and logback for logging and added debugging information to boundingBox.scala.

Summary of Work Created
Code Files:
Shape.scala:
   -  Defined the Shape enum and its cases.
   - Added a draw method for graphical rendering.
   - boundingBox.scala:

- Implemented the boundingBox behavior using functional constructs.
draw.scala:

- Implemented the draw behavior using the Doodle library.
ShapeRenderer.scala:

- Rendered shapes to BufferedImage for testing.
TestDraw.scala:

- Tested the draw behavior and generated images.
TestFixtures.scala:

- Defined reusable test fixtures (shapes).
TestSize.scala:

- Tested the size behavior.
TestHeight.scala:

- Tested the height behavior.
TestScale.scala:

- Tested the scale behavior.

Error Fixes:
Fixed multiple compilation and test errors across several iterations.

Logging:
Integrated slf4j and logback for debugging.
