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

A **subclass can call a constructor defined by its superclass** by use of the following form os **super**.

**_super(parameter-list)_**

Here, _parameter list_ specifies any parameters neede by the constructor in the superclass. **super() must always be the first statement executed inside a subclass constructor**.

```Java
// Add constructors to TwoDShape
class TwoDShape {
    private double width;
    private double height;

    // Parameterized constructor
    TwoDShape(double w, double h) {
        width = w;
        height = h;
    }

    // Accessor methods for width and height
    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    // void setWidth(double w) {
    // width = w;
    // }

    // void setHeight(double h) {
    // height = h;
    // }

    void showDim() {
        System.out.println("Width and height are " + width + " and " + height);
    }
}

// A subclass of TwoDShape for triangles
class Triangle extends TwoDShape {
    private String style;

    Triangle(String s, double w, double h) {
        super(w, h);// call superclass constructor
        style = s;
    }

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

class Shapes4 {
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

Here **Triangle() calls super()** with the parameters **w and h**. This causes the **TwoDShape()** constructor to be **called** which **initiliizes width and height** using these values.

**The key point is that once you have created a superclass that defines the general aspects
of an object, that superclass can be inherited to form specialized classes. Each subclass
simply adds its own, unique attributes. This is the essence of inheritance.**

## Creating a Multilevel Hierarchy

You can build hierarchies that contain as **many layers of inheritance**
as you like. **It is perfectly acceptable to use a subclass as a superclass of another**.

Because of inheritance, ColorTriangle can make use of the previously defined classes of Triangle and TwoDShape, adding only the extra information it needs for its own, specific application. **This is part of the value of inheritance; it allows the reuse of code**.

**super( ) always refers to the constructor in the closest superclass;**

```Java
// A multilevel hierarchy
class TwoDShape {
    private double width;
    private double height;

    // A default constructor
    TwoDShape() {
        width = height = 0.0;
    }

    // Parameterized constructor
    TwoDShape(double w, double h) {
        width = w;
        height = h;
    }

    // Constructor object with equl width and height
    TwoDShape(double x) {
        width = height = x;
    }

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

// Extends TwoDShape
class Triangle extends TwoDShape {
    private String style;

    // A default constructor
    Triangle() {
        super();
        style = "none";
    }

    // Constructor
    Triangle(String s, double w, double h) {
        super(w, h);// Call superclass constructor
        style = "filled";
    }

    // One argument constructor
    Triangle(double x) {
        super(x);// call superclass constructor
        style = "filled";
    }

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

/*
 * Extend Triangle
 * ColorTriangle inherits Triangle, which
 * is descended from TwoDShape, so
 * ColorTriangle includes all members
 * of Triangle and TwoDShape.
 */
class ColorTriangle extends Triangle {
    private String color;

    ColorTriangle(String c, String s, double w, double h) {
        super(s, w, h);
        color = c;
    }

    String getColor() {
        return color;
    }

    void showColor() {
        System.out.println("Color is " + color);
    }
}

class Shapes6 {
    public static void main(String[] args) {
        ColorTriangle t1 = new ColorTriangle("Blue", "outlined", 8.0, 12.0);
        ColorTriangle t2 = new ColorTriangle("Red", "filled", 2.0, 2.0);

        System.out.println("Info fot t1: ");
        t1.showStyle();
        t1.showDim();
        t1.showColor();
        System.out.println("Area is " + t1.area());
        System.out.println();

        System.out.println("Info fot t2: ");
        t2.showStyle();
        t2.showDim();
        t2.showColor();
        System.out.println("Area is " + t2.area());
        System.out.println();
    }
}
```

## When Are CONstructors Executed?

In a class hierarchy, constructors complete their execution in order of derivation, **from superclass to subclass**. If super( ) is not used, then the default (parameterless) constructor of each superclass will be executed.

```Java
//Demonstrate when constructors are executed
//Create a super class
class A {
    A() {
        System.out.println("Constructing A.");
    }
}

// Create a subclass by extending class A
class B extends A {
    B() {
        System.out.println("Constructing B.");
    }
}

// Create another subclass by extending B
class C extends B {
    C() {
        System.out.println("Constructing C.");
    }
}

class OrderOfConstruction {
    public static void main(String[] args) {
        C c = new C();
    }

}
```

Output:\
Constructing A.\
Constructing B.\
Constructing C.

## Superclass References and Subclass Objects

**Java is a strongly typed language**. Aside from the standard conversions and automatic promotions that apply to its primitive types, **type compatibility is strictly enforced**. Therefore, **a reference variable for one class type cannot normally refer to an object of another class type**.

```Java
//This will not compile
class X {
    int a;

    X(int i) {
        a = i;
    }
}

class Y {
    int a;

    Y(int i) {
        a = i;
    }
}

class IncompatibleRef {
    public static void main(String[] args) {
        X x = new X(10);
        X x2;
        Y y = new Y(5);
        x2 = x; // OK, both the same type
        x2 = y; // Error, not the same type. Cannot convert from Y yo X
    }
}

```

Even though class X and class Y are structurally the same, **it is not possible to assign an X reference to a Y object** because they have **different types**. In general, **an object reference variable can refer only to objects of its type**.

**A superclass reference can refer to a subclass object**.

```Java
// A superclass reference can refer to a subclass object
class X {
    int a;

    X(int i) {
        a = i;
    }
}

class Y extends X {
    int b;

    Y(int i, int j) {
        super(j);
        b = i;
    }
}

class SupSubRef {
    public static void main(String[] args) {
        X x = new X(10);
        X x2;
        Y y = new Y(5, 6);

        x2 = x; // OK, both the same type
        System.out.println("x2.a: " + x2.a);
        x2 = y;// Still OK because Y is derived from X;
        System.out.println("x2.a " + x2.a);
        // X references know only about X members
        x2.a = 19; // OK
        // x2.b = 27 //Error, X doesn't have a b member
    }
}
```

Output:\
x2.a: 10\
x2.a 6

Here, Y is now derived from X;thus, it is permissible for x2 to be assigned a reference to a Y object. It is important to understand that it is the type of the reference variable, not the type of the object that refers to , that determines what members can be accessed.

An important place where subclass references are assigned to superclass variables is when **constructors are called in a class hierarchy**

```Java
import javax.swing.plaf.basic.BasicTreeUI.TreeIncrementAction;

class TwoDShape {
    private double width;
    private double height;

    // A default constructor
    TwoDShape() {
        width = height = 0.0;
    }

    // Parameterized constructor
    TwoDShape(double w, double h) {
        width = w;
        height = h;
    }

    // Construct an object with equal width and height
    TwoDShape(double x) {
        width = height = x;
    }

    // Construct an object from an object.
    TwoDShape(TwoDShape ob) {
        width = ob.width;
        height = ob.height;
    }

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

    // A default contructor
    Triangle() {
        super();
        style = "none";
    }

    // Constructor for Triangle
    Triangle(String s, double w, double h) {
        super(w, h);// Call superclass constructor
        style = s;
    }

    // One argument constructor
    Triangle(double x) {
        super(x);// call superclass constructor
        style = "filled";
    }

    // COnstruct an object from an object
    Triangle(Triangle ob) {
        super(ob); // Pass object to TwoDShape constructor
        style = ob.style;
    }

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

class Shapes7 {
    public static void main(String[] args) {
        Triangle t1 = new Triangle("outlined", 8.0, 12.0);
        // make a copy of t1
        Triangle t2 = new Triangle(t1);

        System.out.println("Info fot t1: ");
        t1.showStyle();
        t1.showDim();
        System.out.println("Area is " + t1.area());
        System.out.println();

        System.out.println("Info fot t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Area is " + t2.area());
        System.out.println();

    }
}
```

Output:\
Info fot t1: \
Triangle is outlined\
Width and height are 8.0 and 12.0\
Area is 48.0

Info fot t2: \
Triangle is outlined\
Width and height are 8.0 and 12.0\
Area is 48.0

The key point is that TwoDshape( ) is expecting a TwoDShape object. However, Triangle( ) passes it a Triangle object. The reason this works is because, as explained, a superclass reference can refer to a subclass object. Thus, it is perfectly acceptable to pass TwoDShape( ) a reference to an object of a class derived from TwoDShape. Because the TwoDShape( ) constructor is initializing only those portions of the subclass object that are members of TwoDShape, it doesn’t matter that the object might also contain other members added by derived classes.
