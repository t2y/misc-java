package misc.java;

public interface ExpressionComparator<O, T> {
  boolean test(O o, T t1, T t2);
}
