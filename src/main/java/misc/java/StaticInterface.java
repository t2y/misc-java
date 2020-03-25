package misc.java;

public interface StaticInterface {

  static int getSum(int x, int y) {
    return x + y;
  }

  public interface Sub1 extends StaticInterface {}

  public interface Sub2 extends StaticInterface {
    static int getSum(int x, int y) {
      return x + y + 1;
    }
  }
}
