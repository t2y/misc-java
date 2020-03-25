package misc.java;

public abstract class StaticAbstract {

  static int getSum(int x, int y) {
    return x + y;
  }

  static int getSub(int x, int y) {
    return x - y;
  }

  public class Sub1 extends StaticAbstract {}
}
