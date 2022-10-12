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
