# Inheritance

Inheritance is **one of the three foundation principles** of **object-oriented programming** because it **allows the creation of hierarchical classifications.**. Using inheritance, you can create a general class that defines **traits common** to a set of **related items**.

This class can then be inherited by other, more specific classes, each adding those things that are unique to it. In Java, a **class tha is inherited** is called a **superclass**. The **class that does the inheriting** is called a **subclass**.

Therefore, a **subclass** is a specialized vversion of a superclass. It **inherits** all of the **variables** and **methods** defined by the superclass and adds its own, unique elements.

## Inheritance Basics

Java supports inheritance by **allowing one class to incorporate another class into its declaration**.This is done by using the **extends** keyword.
Thus, the subclass adds to (extends) the superclass

**_class subclass-name extends superclass-name {\
// body of class\
}_**

```Java
// A simple class hierarchy
// A class for two-dimensional objects
class TwoDShape {
    double width;
    double height;

    void showDim() {
        System.out.println("Width and height are " + width + " and " + height);
    }
}

/*
 * A sub class of TwoDShape for triangles
 * Triangle inherits TwoDShape
 */
class Triangle extends TwoDShape {
    String style;

    /*
     * Triangle can refer to the members of TwoDShape
     * as if they were declared by Triangle
     */
    double area() {
        return width * height / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

class Rectangle extends TwoDShape {
    boolean isSquare() {
        if (width == height)
            return true;
        return false;
    }

    double area() {
        return width * height;
    }
}

class Shapes {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle();
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();

        /*
         * All members of Triangle are available to Triangle
         * objects, even those inherited from TwoDShape
         */
        t1.width = 4.0;
        t1.height = 4.0;
        t1.style = "filled";

        t2.width = 8.0;
        t2.height = 12.0;
        t2.style = "outlined";

        System.out.println("Info for t1: ");
        t1.showStyle();
        t1.showDim();
        System.out.println("Area is " + t1.area());

        System.out.println();

        System.out.println("Info for t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Area is " + t2.area());

        System.out.println();
        // Rectangle
        r1.width = 4.0;
        r1.height = 8.0;

        r2.width = 4.0;
        r2.height = 4.0;

        System.out.println("Info for r1: ");
        System.out.println("Is a square : " + r1.isSquare());
        r1.showDim();
        System.out.println("Area is " + r1.area());

        System.out.println();
        System.out.println("Info for r2: ");
        System.out.println("Is a square : " + r2.isSquare());
        r2.showDim();
        System.out.println("Area is " + r2.area());
    }
}
```

Because **Triangle includes all of the members of its superclass**, TwoDShape, it can access width and height inside area( ). Also, inside main( ), objects t1 and t2 can refer to width and height directly, as if they were declared by Triangle.

You can specify **only one superclass for any subclass** that you create. **Java does not support the inheritance of multiple superclasses into a single subclass**

You can, however, create a **hierarchy of inheritance in which a subclass becomes a superclass of another subclass**. Of course, **no class can be a superclass of itself**.

A major advantage of **inheritance** is that once you have created a superclass that **defines the attributes common to a set of objects**, it can be used to **create any number of more specific subclasses**

## Member Access and Inheritance

Inheriting a class does not averrule the **private** access restriction. Thus, even though a **subclass** includes all the members of its superclass, it **cannot access** those **members** of the **superclass** that have been declared **private**.

```Java
// Private members are not inherited.
// This example will not compile.
// A class for two-dimensional objects.
class TwoDShape {
    private double width; // these are
    private double height; // now private
    void showDim() {
        System.out.println("Width and height are " +
        width + " and " + height);
    }
}
// A subclass of TwoDShape for triangles.
class Triangle extends TwoDShape {
    String style;
    double area() {
        return width * height / 2; //Error Can’t access a private member
    }
    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}
```

**Accessor methods** are needed to provide access the private class members. The sollowingg example illustrates it.

```Java
// Use accessor methods to set and get private members.
//A class for two-dimensional objects
class TwoDShape {
    // These are now private
    private double width;
    private double height;

    // Accessor methods for width and height
    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    void setWidth(double w) {
        width = w;
    }

    void setHeight(double h) {
        height = h;
    }

    void showDim() {
        System.out.println("Width and height are " + width + " and " + height);

    }
}

// A subclass of TwoDShape for triangles.
class Triangle extends TwoDShape {
    String style;

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

class Shapes2 {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle();

        t1.setWidth(4.0);
        t1.setHeight(4.0);
        t1.style = "filled";

        t2.setWidth(8.0);
        t2.setHeight(12.0);
        t2.style = "outlined";

        System.out.println("Info for t1: ");
        t1.showStyle();
        t1.showDim();
        System.out.println("Area is " + t1.area());
        System.out.println();
        System.out.println("Info for t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Area is " + t2.area());

    }
}
```

## Constructors and Inheritance

In a hierarchy, its possible for both superclasses and subclasses to have their own constructors.The **constructor for the superclass constructs the superclass portion** of the object, and the **constructor for the subclass constructs the subclass part**, their construction must be **separate**.

The sollowing exampple illustrates it.

```Java
// Add a constructor to Triangle
//A class for two-dimensional objects
class TwoDShape {
    // These are now private
    private double width;
    private double height;

    // Accessor methods for width and height
    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    void setWidth(double w) {
        width = w;
    }

    void setHeight(double h) {
        height = h;
    }

    void showDim() {
        System.out.println("Width and height are " + width + " and " + height);
    }
}

// A subclass of TwoDShape for triangles
class Triangle extends TwoDShape {
    private String style;

    // Constructor
    Triangle(String s, double w, double h) {
        // Initialize TwoDShape portion of object
        setWidth(w);
        setHeight(h);
        style = s;
    }

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

class Shapes3 {
    public static void main(String[] args) {
        Triangle t1 = new Triangle("filled", 4.0, 4.0);
        Triangle t2 = new Triangle("outlined", 8.0, 12.0);

        System.out.println("Info for t1: ");
        t1.showStyle();
        t1.showDim();
        System.out.println("Area is " + t1.area());
        System.out.println();

        System.out.println("Info for t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Area is " + t2.area());
    }
}
```

## Using super to Call Superclass Constructors
