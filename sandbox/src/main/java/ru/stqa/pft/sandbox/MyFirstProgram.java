package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    String name = "Roman";
    hello(name);

    Square s = new Square(5);
    System.out.println("Площадь квардата со стороной " + s.l + " равна " + area(s));


    Rectangle r = new Rectangle(4,6);

    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));
}

  public static void hello(String name) {
    System.out.println("Hello, " + name);
  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r) {
    return r.a * r.b;
  }
}
