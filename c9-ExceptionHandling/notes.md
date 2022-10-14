# Exception Handling

This chapter discusses exception handling. An **exception** is an **error that occurs at run time**. Using Java’s exception handling subsystem you can, in a structured and controlled manner,handle run-time errors.

## The Exception Hierarchy

In Java, all exceptions are **represented by classes**. All exception classes are **derived** from a class called **Throwable**.There are **two direct subclasses** of Throwable: **Exception** and **Error**.

## Exception Handling Fundamentals

Java exception handling is managed via five keywords: **try, catch, throw, throws, and finally**.

Program statements that you want to monitor for exceptions are contained within a try block. If an exception occurs within the try block, it is thrown. Your code can catch this exception using catch and handle it in some rational manner.

To manually throw an exception, use the keyword **throw**. In some cases, an exception that is thrown out of a method must be specified as such by a **throws** clause. Any code that absolutely must be executed upon exiting from a **try** block is put in a **finally** block.

Exceptions are generated in three different ways:

1. The **JVM can generate an exception** in response to some internal error which is **beyond your control**

2. **Standard exceptions**, such as those corresponding to divide-by-zero or array index out-of-bounds, are generated by **errors in program code**. **You** need to **handle these exceptions**.

3. **You can manually generate an exception** by using the **throw** statement. No matter how an exception is generated, it is handled in the same way.

## Using try and catch

At the core of exception handling are **try** and **catch**. These keywords work together;**you can’t have a catch without a try**. Here is the general form of the try/catch exception handling blocks:

```Java
try {
    // block of code to monitor for errors
}
catch (ExcepType1 exOb) {
    // handler for ExcepType1
}
catch (ExcepType2 exOb) {
    // handler for ExcepType2
}
.
.
.
```

Here, **ExcepType** is the type of exception that has occurred. When an exception is thrown, it is caught by its corresponding catch statement, which then processes the exception. As the general form shows, **there can be more than one catch statement associated with a try**. The **type** of the **exception** determines which catch statement is **executed**.

```Java
//Demonstrate exception handling
class ExcDemo1 {
    public static void main(String[] args) {
        int[] nums = new int[4];
        try {
            System.out.println("Before exception is generated.");
            // Generate an index out-of-bounds exception
            nums[7] = 10;
            System.out.println("This won't be displayed");
        } catch (ArrayIndexOutOfBoundsException exc) {
            // catch the exception
            System.out.println("Index out-of-bounds!");
        }
        System.out.println("After catch statement.");
    }
}
```

Output:\
Before exception is generated.\
Index out-of-bounds!\
After catch statement.