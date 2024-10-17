# lectureCode-sp21
## 简介
讲座中的代码以及一些练习和笔记

### 嵌套类

如果嵌套类不需要访问外部类的实例方法或实例变量（例如，SLList类的`first`、`addFirst`、`getFirst`等实例成员），可以将嵌套类声明为静态。声明为静态后，这个嵌套类就和普通的类类似，它**不能访问外部类的任何实例成员**，只能访问外部类的静态成员。

将嵌套类声明为 **静态** 可以节省内存，原因在于静态嵌套类不再隐式地持有对其外部类（`SLList`）的引用。

```java
public class SLList {
       public static class IntNode {
            public int item;
            public IntNode next;
            public IntNode(int i, IntNode n) {
                item = i;
                next = n;
            }
       }

       private IntNode first;
...
```

### 方法重载

https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html

JAVA 编译器可以通过不同数量以及不同类型的方法形参来区别同一类中相同名字的方法，称为**方法重载**。

### 泛型

### Arrays

一个有意思的例子

```java
int[][] pascalsTriangle;
pascalsTriangle = new int[4][]; // 未确定时，每一个赋值为null，没有引用
int[] rowZero = pascalsTriangle[0];
```

### 反射

```java
import java.lang.reflect.Field;
import java.util.Arrays;
import static java.lang.System.out;

enum Tweedle { DEE, DUM }

public class Book {
    public long chapters = 0;
    public String[] characters = { "Alice", "White Rabbit" };
    public Tweedle twin = Tweedle.DEE;

    public static void main(String... args) {
	Book book = new Book();
	String fmt = "%6S:  %-12s = %s%n";

	try {
	    Class<?> c = book.getClass();

	    Field chap = c.getDeclaredField("chapters");
	    out.format(fmt, "before", "chapters", book.chapters);
  	    chap.setLong(book, 12);
	    out.format(fmt, "after", "chapters", chap.getLong(book));

	    Field chars = c.getDeclaredField("characters");
	    out.format(fmt, "before", "characters",
		       Arrays.asList(book.characters));
	    String[] newChars = { "Queen", "King" };
	    chars.set(book, newChars);
	    out.format(fmt, "after", "characters",
		       Arrays.asList(book.characters));

	    Field t = c.getDeclaredField("twin");
	    out.format(fmt, "before", "twin", book.twin);
	    t.set(book, Tweedle.DUM);
	    out.format(fmt, "after", "twin", t.get(book));

        // production code should handle these exceptions more gracefully
	} catch (NoSuchFieldException x) {
	    x.printStackTrace();
	} catch (IllegalAccessException x) {
	    x.printStackTrace();
	}
    }
}
```

### 引用类型的回收

如果例如 `IntNode[--size] = null;`，移除最后一个元素后，将引用类型置为null，可以节省空间。因为当引用类型没有被任何数据引用时，则JAVA会自动将其回收。

### 接口

接口可以使用 `default` 关键字来定义默认行为

```java
default public void print() {
    for (int i = 0; i < size(); i += 1) {
        System.out.print(get(i) + " ");
    }
    System.out.println();
}
```

### 动态方法选择

动态方法选择不对重载生效

```java
public static void peek(List61B<String> list) {
    System.out.println(list.getLast());
}
public static void peek(SLList<String> list) {
    System.out.println(list.getFirst());
}




SLList<String> SP = new SLList<String>();
List61B<String> LP = SP;
SP.addLast("elk");
SP.addLast("are");
SP.addLast("cool");
peek(SP);
peek(LP);
```

`peek`函数依然是按照静态类型选择重载的函数。

### Extends

##### Constructor

若我们不显式调用`super()`，Java会隐式调用父类的无参构造方法。

若父类没有无参构造方法且我们没有显式调用`super(...args)` ，则编译会报错。

### Type Checking and Casting

一个很容易出错的地方。

```java
VengefulSLList<Integer> vsl = new VengefulSLList<Integer>(9);
SLList<Integer> sl = vsl;
sl.addLast(50);
sl.removeLast();
sl.printLostItems();   // 编译时这里会报错
VengefulSLList<Integer> vsl2 = sl; // 编译时这里也会报错
```

之所以会报错因为编译时，只会看静态类型，若静态类型不匹配则会报错。

### Casting

例如

```java
Poodle largerPoodle = (Poodle) maxDog(frank, frankJr);
```

告诉编译器给定的静态类型，但在运行时也可能出现问题。

