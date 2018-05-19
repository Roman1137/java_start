package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    String name = "Roman";
    hello(name);

    double l = 5;
    System.out.println("Площадь квардата со стороной " + l + " равна" + area(l));

    double a = 5, b = 6;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
  }

  public static void hello(String name) {
    System.out.println("Hello, " + name);
  }

  public static double area(double l) {
    return l * l;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}
