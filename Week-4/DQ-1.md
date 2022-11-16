## Topic 4: Discussion Question 1
Explain the difference between (compile time) checked and (runtime) unchecked exceptions. When would you design a checked exception? When would you design an unchecked exception? Summarize your answers and rationale in 300 words.
### Compile Time Exception
> A "compiler is a software program that transforms a program or code written in [a] high level programming language into a low level machine readable language" (making IT simple, 2020, 0:23). 

When a compiler checks the code, if an error is present, the compiler will throw an exception. Syntax and Semantic errors are types of errors that are returned during compile time. When programming syntax is not followed, syntax errors occur. These errors are thrown when the program is compiled.
#### Code Example:
``` Java
public static void main(String[] args) {
    int a = 10;

    System.out.println("the value of a is %d", a); // a compile time exception occurs because 
                                                   // this should be printf and not println 
}
```
### Runtime Exception
> "Runtime is the time at which the executable code is started running" (javaTpoint, n.d.). 

After a program is compiled and executed, runtime errors can occur unpredictably. For example, if a user can input two integers to divide, a divide by zero runtime error will be thrown if the user selects a zero for the second integer.

### Code Example:
``` Java
public static void main(String[] args) {
  int a = 1;
  
  int div = a / 0;
  //Because a number cannot be divided by zero, a dividebyzero runtime error will occur when executed
  System.out.printf("This will throw a divide by 0 runtime error %d: ", div);
}
```
### Differences Between Compile Time and Runtime Exceptions
A compile-time error will be instantly recognizable in the Java Eclipse IDE, along with possible solutions. However, a run-time error will not be immediately apparent, and the programmer must thoroughly debug the code after compiling it to verify that the program is behaving as expected.

### When would you design a checked exception? 
The programmer should implement a checked exception when expecting potential errors, such as a fileNotFound exception. This exception-handling practice is essential so the program will avoid crashing and provide the user with a helpful message or complete another task set a catch statement.

### When would you design an unchecked exception? 
A programmer should use an unchecked exception whenever the possibility arises that a mathematical error is possible. Refer to the divide-by-zero example above to see how this would look.

### References:
javaTpoint. (n.d.). Compile time vs Runtime - javatpoint. www.javatpoint.com. Retrieved November 16, 2022, from https://www.javatpoint.com/compile-time-vs-runtime

making IT simple. (2020, May 30). What is Compiler | Short and Simple Explanation using Animation [Video]. YouTube. https://www.youtube.com/watch?v=Vi8npxRMGac
