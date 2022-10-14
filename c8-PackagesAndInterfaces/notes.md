# Packages and Interfaces

**Packages** are groups of **related classes**. Packages help organize your code and provide **another layer of encapsulation**.

An **interface** defines a **set of methods** that will be implemented by a class.Thus, an interface gives you a way to **specify what a class will do, but not how it will do it**.

## Packages

In programming, it is often helpful to group related pieces of a program together, a package serves two purposes:

- It provides a mechanism by which **related** pieces of a program can be **organized** as a **unit**.
- A package participtes in Java's **access control** mechanism

Classes defined within a package can be made private to that package and not accessible by code outside the package. Thus, **the package provides a means by which classes can be encapsulated**.In a **package**, you can define code that is **accessible** by other code **within the same package** but **not** by code **outside the package**.

## Defining a Package

**All classes in Java belong to some package**. When no package statement is specified, the **default package is used**. The default package has no name, wchich makes the default package transparent. This is the general form of the **package statement**:

**_package packageName;_**

Like the rest of Java, **package names are case sensitive**. You can create a **hierarchy of packages**. You must create directories that support the package hierarchy that yopu create.

**_pack1.pack2.pack3...packN;_**

## Pakcages and member access

The **visibility** of an element is affected by its **access specification**—private, public, protected, or default—and the **package in which it resides**. Thus, as it relates to classes and packages, the visibility of an element is determined by its **visibility within a class and its visibility within a package**

Members explicitly declared **public** are the most visible, and can be accessed from different classes and different packages. A **private** member is accessible only to the other members of its class. A **private** member is unaffected by its membership in a package. A member specified as **protected** is accessible within its package and to subclasses in other packages.

When a class is declared as **public**, it is accessible outside its package.
If a class has default access, it can be accessed only by other code within its same package. Also, a class that is declared **public must reside in a file by the same name**.

**Class member access**
| | **Private Member** | **Default Member** | **Protected Member** | **Public Member** |
|-|----------------|----------------|------------------|---------------|
|**Visible within<br>same class**| Yes | Yes | Yes | Yes |
|**Visible within<br>same package<br>by subclass**| No | Yes | Yes | Yes |
|**Visible within<br>same package<br> by non-subclass**| No | Yes | Yes | Yes |
|**Visible within<br>different package<br>by subclass**| No | No | Yes | Yes |
|**Visible within<br>differnet package<br>by non-subclass**| No | No | No | Yes |

## Understanding Protected Members

The **protected** modifier creates a member that is accessible within its package and to subclasses in other packages. Thus, a protected member is available for all subclasses to use but is still **protected** from arbitrary access by code outside its package.

```Java
// A short package demonstration
package bookpack;

public class Book {
    // these are now protected
    protected String title;
    protected String author;
    protected int pubDate;

    public Book(String t, String a, int d) {
        title = t;
        author = a;
        pubDate = d;
    }

    public void show() {
        System.out.println(title);
        System.out.println(author);
        System.out.println(pubDate);
        System.out.println();
    }
}
```

```Java
//Demonstrate protected
package bookpackext;

class ExtBook extends bookpack.Book {
    private String publisher;

    public ExtBook(String t, String a, int d, String p) {
        super(t, a, d);
        publisher = p;
    }

    public void show() {
        super.show();
        System.out.println(publisher);
        System.out.println();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String p) {
        publisher = p;
    }

    /*
     * These are OK because subclass can access a
     * protected member
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public int getPubDate() {
        return pubDate;
    }

    public void setPubDate(int d) {
        pubDate = d;
    }
}

class ProtectDemo {
    public static void main(String[] args) {
        ExtBook[] books = new ExtBook[5];
        books[0] = new ExtBook("Java: A Beginner's Guide", "Schildt", 2022, "McGraw Hill");
        books[1] = new ExtBook("Java: The Complete Reference", "Schildt", 2022, "McGraw Hill");
        books[2] = new ExtBook("1984", "Orwell", 1949, "Harcourt Brace Jovanovich");
        books[3] = new ExtBook("Red Storm Rising", "Clancy", 1986, "Putnam");
        books[4] = new ExtBook("On the Road", "Kerouac", 1955, "Viking");
        for (ExtBook ext : books)
            ext.show();

        // Find books by author
        System.out.println("Showing all books by Schildt");
        // books[0].title= "Test title"; //Error - not accessible
        books[0].setTitle("Java: A Beginner's Guide - Modified");

        for (ExtBook ext : books)
            if (ext.getAuthor() == "Schildt")
                System.out.println(ext.getTitle());

    }
}
```

Output:\
Java: A Beginner's Guide\
Schildt\
2022

McGraw Hill

Java: The Complete Reference\
Schildt\
2022

McGraw Hill

1984\
Orwell\
1949

Harcourt Brace Jovanovich

Red Storm Rising\
Clancy\
1986

Putnam

On the Road\
Kerouac\
1955

Viking

Showing all books by Schildt\
Java: A Beginner's Guide - Modified\
Java: The Complete Reference

Look first at the code inside **ExtBook**. Because **ExtBook** extends **Book**, it has access to the **protected** members of **Book**, even though **ExtBook** is in a different package. Thus, it can access **title**, **author**, and **pubDate** directly, as it does in the accessor methods it creates for those variables. However, in **ProtectDemo**, access to these variables is denied because **ProtectDemo** is not a subclass of **Book**.

## Importing Packages

Using **import** you can bring one or more members of a package into view. This allows you to use those members directly, without explicit package qualification.

**_import package.classname;_**

If you want to import the entire contents of a package, **use an asterisk (\*)** for the class name. Here are examples of both forms:

i**mport mypack.MyClass\
import mypack.\*;**

Example

```Java
//Demonstrate import
package bookpackext;

import bookpack.*;

//Use the Book vlass from bookpack
class UseBook {
    public static void main(String[] args) {
        //Now, you can refer to Book directly, without qualification
        Book[] books = new Book[5];
        books[0] = new Book("Java: A Beginner's Guide", "Schildt", 2022);
        books[1] = new Book("Java: The Complete Reference", "Schildt", 2022);
        books[2] = new Book("1984", "Orwell", 1949);
        books[3] = new Book("Red Storm Rising", "Clancy", 1986);
        books[4] = new Book("On the Road", "Kerouac", 1955);
        for (Book b : books)
            b.show();
    }
}
```

## Interfaces

In object-oriented programming, it is sometimes helpful to **define what a class must do but not how it will do it**. You have already seen an **example** of this: the **abstract method**. An abstract method defines the signature for a method but provides no implementation, thus an abstract method **specifies the interface to the method but not the implementation**.

In Java, you can fully **separate a class’ interface** from its implementation by using the keyword **interface**.. Thus, an **interface specifies what must be done**, but not how to do it. Once an interface is defined,**any number of classes can implement it**. Also, **one class can implement any number of interfaces**.

By providing the **interface keyword**, Java allows you to fully utilize the **“one interface, multiple methods” aspect of polymorphism.**

Here is a simplified general form of a traditional interface:

```Text
access interface name {
    ret-type method-name1(param-list);
    ret-type method-name2(param-list);
    type var1 = value;
    type var2 = value;
    // ...
    ret-type method-nameN(param-list);
    type varN = value;
}
```

When **no access modifier is included**, then default access results, and the **interface is available only to other members of its package**. When it is declared as **public**, the interface can be used by **any other code**. **(When an interface is declared public, it must be in a file of the same name.)** name is the name of the interface and can be any valid identifier.

**Variables declared in an interface** are not instance variables. Instead, they are **implicitly public, final, and static and must be initialized. Thus, they are essentially constants.**

## Implementing Interfaces

Example

```Java
public interface Series {
    int getNext(); // return next number in series

    void reset(); // restart

    void setStart(int x); // set starting value
}
```

It is both permissible and common for classes that implement interfaces to define additional members of their own, for example getPrevious();

```Java
package seriespack;

// Implement Series
class ByTwos implements Series {
    int start;
    int val;
    int prev;

    ByTwos() {
        start = 0;
        val = 0;
        prev = -2;
    }

    public int getNext() {
        prev = val;
        val += 2;
        return val;
    }

    public void reset() {
        val = start;
        prev = start - 2;
    }

    public void setStart(int x) {
        start = x;
        val = x;
        prev = x - 2;
    }

    // Add a method not defined by Series
    int getPrevious() {
        return prev;
    }
}
```

As explained, any number of classes can implement an interface. For example, here both classes ByTwos and ByThrees use the same Series interface.

```Java
package seriespack;

// Implement Series
class ByThrees implements Series {
    int start;
    int val;

    ByThrees() {
        start = 0;
        val = 0;
    }

    public int getNext() {
        val += 3;
        return val;
    }

    public void reset() {
        val = start;
    }

    public void setStart(int x) {
        start = x;
        val = x;
    }
}

```

Final, the main class execute the following using both classes

```Java
package seriespack;

class SeriesDemo {
    public static void main(String[] args) {
        ByTwos ob = new ByTwos();
        ByThrees obt = new ByThrees();

        for (int i = 0; i < 5; i++)
            System.out.println("Prevoius : " + ob.getPrevious() + "\tCurrent: " + 2 * i + "\tNext: " + ob.getNext());

        System.out.println("\nReseting");
        ob.reset();
        for (int i = 0; i < 5; i++)
            System.out.println("Prevoius : " + ob.getPrevious() + "\tCurrent: " + 2 * i + "\tNext: " + ob.getNext());

        System.out.println("\nStarting at 100");
        ob.setStart(100);
        for (int i = 0; i < 5; i++)
            System.out.println(
                    "Prevoius : " + ob.getPrevious() + "\tCurrent: " + (2 * i + 100) + "\tNext: " + ob.getNext());

        System.out.println("\nBy Threes from 0 to 30");
        for (int i = 0; i <= 10; i++)
            System.out.println("Current: " + 3 * i + "\tNext: " + obt.getNext());
    }
}
```

One more point: **If a class includes an interface but does not fully implement the methods defined by that interface, then that class must be declared abstract.** No objects of such a class can be created, but it can be used as an abstract superclass, allowing subclasses to provide the complete implementation.

## Using Interface References

You can create an **interface reference variable**. Such a variable **can refer to any object that implements its interface**. When you call a method on an object through an interface reference, it is the version of the method implemented by the object that is executed. **This process is similar to using a superclass reference to access a subclass object**

The following example illustrates this process

```Java
package seriespack;

class SeriesDemo2 {
    public static void main(String[] args) {
        ByTwos twoOb = new ByTwos();
        ByThrees threeOb = new ByThrees();
        Series ob;

        for (int i = 0; i < 5; i++) {
            ob = twoOb;
            System.out.println("Next ByTwos value is " + ob.getNext());
            ob = threeOb;
            System.out.println("Next ByThrees value is " + ob.getNext());
        }
    }
}
```

**ob** is declared to be a **reference to a Series interface**. This means that it can be used to **store references to any object that implements Series**. In this case, it is used to refer to twoOb and threeOb, which are objects of type ByTwos and ByThrees, respectively, which both implement Series. An interface reference variable has **knowledge only of the methods declared by its interface declaration**. Thus, ob could not be used to access any other variables or methods that might be supported by the object.

## Interfaces Can Be Extended

One interface can inherit another by use of the keyword extends. The **syntax is the same as for inheriting classes**. When a class implements an interface that inherits another interface, **it must provide implementations for all methods required by the interface inheritance chain**. Following is an example:

```Java
package iextended;

interface A {
    void meth1();

    void meth2();
}
```

```Java
package iextended;

//B now includes meth1() and meth()2 - it adds meth3()
interface B extends A {
    void meth3();
}
```

```Java
package iextended;

//This calss must implement all of A and B
class MyClass implements B {
    public void meth1() {
        System.out.println("Implement meth1().");
    }

    public void meth2() {
        System.out.println("Implement meth2().");
    }

    public void meth3() {
        System.out.println("Implement meth3().");
    }
}
```

```Java
package iextended;

class IFExtend {
    public static void main(String[] args) {
        MyClass ob = new MyClass();
        ob.meth1();
        ob.meth2();
        ob.meth3();
    }
}
```

## Default Interface Methods

The release of JDK 8 changed this by adding a new capability to interface called the **default method**. A default method **lets you define a default implementation for an interface method**. In other words, by use of a default method, **it is possible for an interface method to provide a body, rather than being abstract**. During its development, the default method was also referred to as an **extension method**, and you will likely see **both terms used**.

The addition of default methods does not change a key aspect of interface: **an interface still cannot have instance variables**. Thus, the defining difference between an interface and a class is that a c**lass can maintain state information, but an interface cannot**.

## Default Method Fundamentals

An interface default method is defined similar to the way a method is defined by a class. The primary difference is that the declaration is preceded by the keyword default. For example, consider this simple interface.

```Java
package defaultinpack;

public interface MyIF {
    // This is a "normal" interface method declaration
    // It does NOT define a default implementation
    int getUserID();

    // This is a default method. Notice that it provides
    // a default implementation
    default int getAdminID() {
        return 1;
    }
}
```

Because getAdminID( ) includes a **default** implementation, it is not necessary for an implementing class to override it. In other words, **if an implementing class does not provide its own implementation, the default is used**. For example, the MyIFImp class shown next is perfectly valid:

```Java
package defaultinpack;

//Implement MyIf
class MyIFImp implements MyIF {
   // Only getUserID() defined by MyIF needs to be implementd
   // getAdminID() can be allowed to default
   public int getUserID() {
       return 100;
   }
}
```

```Java
package defaultinpack;

class MyIFImp2 implements MyIF {
    // Here, implements for both getUserId()
    // and getAdminId() are provided
    public int getUserID() {
        return 100;
    }

    public int getAdminID() {
        return 42;
    }
}
```

Both are valid as shown

```Java
package defaultinpack;

//Use the default method
class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIFImp obj = new MyIFImp();
        MyIFImp2 obj2 = new MyIFImp2();
        // Can call getUserID(), because it is explicitly
        // implemented by MyIFImp
        System.out.println("User ID is " + obj.getUserID());

        // Can also call getAdminID() because of default implementation
        System.out.println("Administrator ID is " + obj.getAdminID());

        // Can also be overridden 0for a class method
        System.out.println("Administrator ID overridden is " + obj2.getAdminID());
    }
}
```

Outpout:\
User ID is 100\
Administrator ID is 1\
Administrator ID overridden is 42

The default method provides two major benefits

- It gives you a way to gracefully **evolve interfaces** over time **without breaking existing code**.

- It provides **optional functionality** without requiring that a class provide a placeholder implementation when that functionality is not needed.

## Use static Methods in an Interface

JDK 8 added another new capability to interface: the ability to **define one or more static methods**. Like static methods in a class, a static method defined by an interface **can be called independently of any object**. Thus, no implementation of the interface is necessary, and no instance of the interface is required in order to call a static method.Instead, a static method is **called by specifying the interface name, followed by a period, followed by the method name.**
Here is the general form:

**_InterfaceName.staticMethodName_**

```Java
package defaultinpack;

public interface MyIF {
    // This is a "normal" interface method declaration
    // It does NOT define a default implementation
    int getUserID();

    // This is a default method. Notice that it provides
    // a default implementation
    default int getAdminID() {
        return 1;
    }

    // This is a static interface method
    static int getUniversalID() {
        return 0;
    }
}
```

```Java
package defaultinpack;

//Use the default method
class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIFImp obj = new MyIFImp();
        MyIFImp2 obj2 = new MyIFImp2();
        // Can call getUserID(), because it is explicitly
        // implemented by MyIFImp
        System.out.println("User ID is " + obj.getUserID());

        // Can also call getAdminID() because of default implementation
        System.out.println("Administrator ID is " + obj.getAdminID());

        // Can also be overridden 0for a class method
        System.out.println("Administrator ID overridden is " + obj2.getAdminID());

        // Calling interface static method
        System.out.println("Interface static method call : " + MyIF.getUniversalID());
    }
}
```

Output:\
User ID is 100\
Administrator ID is 1\
Administrator ID overridden is 42\
Interface static method call : 0

**One last point: static interface methods are not inherited by either an implementing class or a subinterface.**

## Private Interface Method

Beginning with JDK 9, an **interface can include a private method**. A private interface method can be **called** only by a **default method or another private method defined by the same interface**.

It **cannot be used by code outside the interface** in which it is defined. This restriction **includes subinterfaces** because a **private interface method is not inherited by a subinterface**.

The **key benefit** of a private interface method is that it lets two or more default methods **use a common piece of code**, thus **avoiding code duplication**

```Java
package seriespack;

public interface Series {
    int getNext(); // return next number in series

    // Return an array that contains the next n elements
    // in the series beyond the current element
    default int[] getNextArray(int n) {
        int[] vals = new int[n];
        for (int i = 0; i < n; i++)
            vals[i] = getNext();
        return vals;
    }

    // Return an array that contains the next n elements
    // in the series, after skipping elements.
    default int[] skipAndGetNextArray(int skip, int n) {
        // Skip the specified number of elements.
        getArray(skip);
        return getArray(n);
    }

    // A private method that returns an array containing
    // the next n elements.
    private int[] getArray(int n) {
        int[] vals = new int[n];
        for (int i = 0; i < n; i++)
            vals[i] = getNext();
        return vals;
    }

    void reset(); // restart

    void setStart(int x); // set starting value
}
```

```Java
package seriespack;

class SeriesDemo2 {
    public static void main(String[] args) {
        ByTwos twoOb = new ByTwos();
        ByThrees threeOb = new ByThrees();
        Series ob;

        for (int i = 0; i < 5; i++) {
            ob = twoOb;
            System.out.println("Next ByTwos value is " + ob.getNext());
            ob = threeOb;
            System.out.println("Next ByThrees value is " + ob.getNext());
        }
        // Using default interface method
        ob = threeOb;
        int[] result = ob.getNextArray(10);
        System.out.println("\nThe next " + result.length + " values are:");
        for (int r : result)
            System.out.println("getNextArray(10) default interface method " + r);

        // Using default interface method and private interface method
        ob.reset();
        System.out.println("\nReseting to 0...");
        result = ob.skipAndGetNextArray(5, 5);
        System.out.println("The next " + result.length + " values skipping 5 positions are");
        for (int r : result)
            System.out.println("skipAndGetNextArray(5,5) default private interface method " + r);

    }
}
```

Output:\
Reseting to 0...\
The next 5 values skipping 5 positions are\
skipAndGetNextArray(5,5) default private interface method 18\
skipAndGetNextArray(5,5) default private interface method 21\
skipAndGetNextArray(5,5) default private interface method 24\
skipAndGetNextArray(5,5) default private interface method 27\
skipAndGetNextArray(5,5) default private interface method 30
