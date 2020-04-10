package misc.java;

@FunctionalInterface
public interface ExpressionOperator<T> {
  boolean apply(T t1, T t2);
}
