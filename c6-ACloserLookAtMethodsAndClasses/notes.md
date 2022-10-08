# A Closer Look at Methods and Classes

## Pass Objects to Methods

It is both correct and common to pass objects to methods.

## How Arguments Are Passed

In certain cases, the effects of passing an object will be different, you need to understand in a general sense the two ways in which an argument can be passed to a subroutine.

- **Call-by-value**: This approach **copies** the value of an argument into the formal
  parameter of the subroutine. Therefore , **changes made to the parameter of the subroutine have no effect on on the argument in the call**.

- **Call-by-reference**: In this approach, a reference to an argument (not the value of the argument is passed to the parameter. Inside the subroutine, this reference is used
  to access the actual argument specified in the call. This means that **changes made to the parameter will affect the argument used in to call the subroutine**

Although Java uses call-by-value to pass arguments, the precise effect differs between whether a
primitive type or a reference type is passed.

When you pass a **primitive type**, such as **int** or **double** , to a method, it is **passed by value**. Thus, a **copy of the argument is made**, and what occurs to the parameter that receives the argument **has no effect outside the method**.

When you pass an **object** to a method, the situation changs dramaticallt, because **objects are implicitly passed by reference**. **Changes** to the object inside the method do **affect the object used as an argument**.

## Returning objects

A method can return **any type of data**, including class types such as Strings. You can, of course, also **return objects of classes that yopu create**

When an **object is returned** by a method, it **remains in existence until there are no more references to it**. At that point, it is subject to garbage collection.Thus, an **object won't be destroyed just because the method that created it terminates**.

## Method Overloading

In Java, **two or more methods within the same class can share the same name**, as long as their **parameter declaration are different**. When this is the case, the methods are said to be **overloaded.**

Method overloading is one of the ways that Java implements **polymorphism**. The **type** and/or **number of the paramethers** of each overloaded method must **differ**.

It is **no sufficient** for two methods to **differ only in their return types**. Method overloading supports **polymorphism** because it is one way that Java implements the **"one interface, multiple methods"** paradigm.

**You should not** use the same name to **overload unrelated methods**, you should overload only closely related operations

## Overloading constructors

Like methods, constructors can also be overloaded. Doing so allows you to construct objects in a variety of ways.

## Recursion

In Java a **method can call itself**. This process is called recursion, and a method that calls itself is said to be recursive. In general, **recursion is the process of defining something in terms of itself** and in somewhat similar to a circular definition.

When a method calls itself, new local variables and parameters are allocated storage on the stack, and the mothod code is executed with these new variables from the start. A recursive call **does not make a new copy of the method**. Only the **arguments are new**. As each recursive call returns, the old local variables and parameters are removed from the stack.

## Understanding static

When a member is declared **static**, it can be **accessed before any objects of its class are created**, and **without reference to any object**. You can declare both methods and variables to be static.

**Variables declared as static** are, essentially, **global variables**. When an object is delcared, no copy of a static variable is made. Instead, **all instances of the class share the same static variable**.

The difference between a static method and a normal method is that the **static method is called through its class name**, without nay object of that class being created.

Methods declared as static have several **restrictions**

- They can directly **call only other static methods** in their class.
- They can directly **access only static variables** in their class.
- They do **not have a this reference**

For example, in the following class, the static method **valDivDenom()** is illegal:

```Java
class StaticError {
  int denom = 3; // a normal instance variable
  static int val = 1024; // a static variable
  /* Error! Can't access a non-static variable
  from within a static method. */
  static int valDivDenom() {
    return val/denom; // won't compile!
  }
}
```

Here, **denom** is a normal instance variable that **cannot be accessed within a static method**

## Static Blocks

Sometimes a class will require some type of **initialization before it is ready to create objects**. A **static block** is executed when the class is first loaded. Thus, **it is executed before the class can be used for any other purpose**.

```Java
//Use a static block
class StaticBlock {
    static double rootof2;
    static double rootof3;

    // This block is executed when the class is loaded
    static {
        System.out.println("Inside static block");
        rootof2 = Math.sqrt(2.0);
        rootof3 = Math.sqrt(3.0);
    }

    StaticBlock(String msg) {
        System.out.println(msg);
    }
}

class SDemo3 {
    public static void main(String[] args) {
        StaticBlock ob = new StaticBlock("Inside constructor");
        System.out.println("Square root of 2 is " + StaticBlock.rootof2);
        System.out.println("Square root of 3 is " + StaticBlock.rootof3);
    }
}
```

The output is shown here\
Inside static block\
Inside constructor\
Square root of 2 is 1.4142135623730951\
Square root of 3 is 1.7320508075688772

## Introducing Nested and Inner Classes

A nested class does not exist independently of its enclosing class. Thus, **the scope of a
nested class is bounded by its outer class**. A nested class that is declared directly within its
enclosing class scope is a member of its enclosing class.

```Java
//Use an inner class
class Outer {
    int[] nums;

    Outer(int[] n) {
        nums = n;
    }

    void analyze() {
        Inner inOb = new Inner();
        System.out.println("Minimum: " + inOb.min());
        System.out.println("Maximum: " + inOb.max());
        System.out.println("Average: " + inOb.avg());
    }

    // This is an inner class
    class Inner {
        int min() {
            int m = nums[0];
            for (int i = 1; i < nums.length; i++)
                if (nums[i] < m)
                    m = nums[i];
            return m;
        }

        int max() {
            int m = nums[0];
            for (int i = 1; i < nums.length; i++)
                if (nums[i] > m)
                    m = nums[i];
            return m;
        }

        int avg() {
            int a = 0;
            for (int i = 0; i < nums.length; i++)
                a += nums[i];
            return a / nums.length;
        }
    }
}

class NestedClassDemo {
    public static void main(String[] args) {
        int[] x = { 3, 2, 1, 5, 6, 9, 7, 8 };
        Outer outOb = new Outer(x);
        outOb.analyze();
    }
}
```

The output is shown here\
Minimum: 1\
Maximum: 9\
Average: 5

In this example, the **inner class Inner computes various values from the array nums, which
is a member of Outer**. As explained, an **inner class has access to the members of its enclosing class**, so it is perfectly acceptable for Inner to access the nums array directly. Of course, the opposite is not true. For example, **it would not be possible for analyze( ) to invoke the min( ) method directly, without creating an Inner object.**

It is possible to **nest a class within a block scope**. Doing so simple **creates a localized class that is not known outside its block**.

```Java
// Use ShowBits as a local class
class LocalClassDemo {
    public static void main(String[] args) {
        // An inner class version of ShowBits
        class ShowBits {
            int numbits;

            ShowBits(int n) {
                numbits = n;
            }

            void show(long val) {
                long mask = 1;

                // left-shift a 1 into the proper position
                mask <<= numbits - 1;

                for (; mask != 0; mask >>>= 1) {// Fills the trailing positions with 0 >>>
                    if ((val & mask) != 0)
                        System.out.print("1");
                    else
                        System.out.print("0");

                }
                System.out.println();
            }
        }
        for (byte b = 0; b < 10; b++) {
            System.out.print(b + " in binary: ");
            byteval.show(b);
        }
    }
}
```

The output is shown here\
0 in binary: 00000000\
1 in binary: 00000001\
2 in binary: 00000010\
3 in binary: 00000011\
4 in binary: 00000100\
5 in binary: 00000101\
6 in binary: 00000110\
7 in binary: 00000111\
8 in binary: 00001000\
9 in binary: 00001001

The **ShowBits class is not known outside of main**, and any attempt to access it by any method other than main() will result in an error.

## Varargs: Variable-Length Arguments

Sometimes you will want to create a **method that takes a variable number of arguments**, based on its precise usage. A method that takes a variable number of arguments is **called avariable-arity method**, or simply a **varargs method**. The parameter list for a varargs method is not fixed, but rather variable in length. Thus, a **varargs method can take a variable number of arguments**.

### Varargs Basics

A variable-length argument is **specified by three periods (...)**. For example, here is how to write a method called vaTest( ) that takes a variable number of arguments:

```Java
//Demonstrate variable-length arguments
class VarArgs {
    // vaTest() uses a vararg
    static void vaTest(int... v) {// ... Decalre a variable-length argument list
        System.out.println("Number of args: " + v.length);
        System.out.println("Contents: ");

        for (int i = 0; i < v.length; i++)
            System.out.println(" arg " + i + ": " + v[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        // Notice how vaTest() can be called with a
        // variable number of arguments
        vaTest(10);
        vaTest(1, 2, 3);
        vaTest();
    }
}
```

The output is shown here\
Number of args: 1\
Contents: \
 arg 0: 10

Number of args: 3\
Contents:\
 arg 0: 1\
 arg 1: 2\
 arg 2: 3

Number of args: 0\
Contents:

Inside vaTest( ), **v is operated on as an array**.The **...** syntax simply tells the compiler that a **variable number of arguments will be used**, and that these arguments will be stored in the array referred to by v.

A method can have “normal” parameters along with a variable-length parameter. However,the variable-length parameter must be the last parameter declared by the method. For example,this method declaration is perfectly acceptable:

**int doIt(int a, int b, double c, int ... vals) {**

```Java
// Use varargs with standard arguments
class VarArgs2 {
    // Here, msg is a normal parameter and v is a varargs parameter
    static void vaTest(String msg, int... v) {
        System.out.println(msg + v.length);
        System.out.println("Contents: ");
        for (int i = 0; i < v.length; i++)
            System.out.println(" arg " + i + ": " + v[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest("One vararg: ", 10);
        vaTest("Three varargs: ", 1, 2, 3);
        vaTest("No varargs: ");
    }
}
```

The output from this program is shown here:\
One vararg: 1\
Contents:\
 arg 0: 10

Three varargs: 3\
Contents: \
 arg 0: 1\
 arg 1: 2\
 arg 2: 3

No varargs: 0\
Contents:

Remember, the **varargs parameter must be last**. For example, the following declaration is incorrect:

**int doIt(int a, int b, double c, int ... vals, boolean stopFlag) { //Error!**

Here, there is an **attempt to declare a regular parameter after the varargs parameter, which is illegal**. There is one more restriction to be aware of:

**There must be only one varargs parameter**. For example, this declaration is also invalid:

**int doIt(int a, int b, double c, int ... vals, double ... morevals) { //Error!**

## Overloading Varargs Methods

You can overload a method that takes a variable-length argument.
There are

```Java
class VarArgs3 {
    static void vaTest(int... v) {
        System.out.println("vaTest(int ...): " + "Number of args: " + v.length);
        System.out.println("Contents: ");
        for (int i = 0; i < v.length; i++)
            System.out.println("  arg " + i + ": " + v[i]);
        System.out.println();
    }

    static void vaTest(boolean... v) {
        System.out.println("vaTest(boolean ...): " + "Number of args: " + v.length);
        System.out.println("Contents: ");
        for (int i = 0; i < v.length; i++)
            System.out.println("  arg " + i + ": " + v[i]);
        System.out.println();
    }

    static void vaTest(String msg, int... v) {
        System.out.println("vaTest(String, int ...):  " + msg + v.length);
        System.out.println("Contents: ");
        for (int i = 0; i < v.length; i++)
            System.out.println("  arg " + i + ": " + v[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest(1, 2, 3);
        vaTest("Testing: ", 10, 20);
        vaTest(true, false, false);
    }
}
```

The output from this program is shown here:\
vaTest(int ...): Number of args: 3\
Contents:\
 arg 0: 1\
 arg 1: 2\
 arg 2: 3

vaTest(String, int ...): Testing: 2\
Contents: \
 arg 0: 10\
 arg 1: 20

vaTest(boolean ...): Number of args: 3\
Contents: \
 arg 0: true\
 arg 1: false\
 arg 2: false
