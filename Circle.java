public class Circle {
  int radius;
  String name;

  public double getArea() {
    return 3.14 * radius * radius;
  }

  public static void main(String[] args) {
    Circle pizza;
    pizza = new Circle();
    pizza.radius = 10;
    pizza.name = "자바피자";
    double area = pizza.getArea();
  }
}
