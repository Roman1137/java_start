package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    String name = "Roman";
    hello(name);

    Square s = new Square(5);
    System.out.println("Площадь квардата со стороной " + s.l + " равна " + s.area());


    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
}

  public static void hello(String name) {
    System.out.println("Hello, " + name);
  }
}
