package misc.java;

public class ExpressionComparatorImpl<O extends ExpressionOperator<T>, T>
    implements ExpressionComparator<O, T> {

  @Override
  public boolean test(O o, T t1, T t2) {
    return o.apply(t1, t2);
  }
}
