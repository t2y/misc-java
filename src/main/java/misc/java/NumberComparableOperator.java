package misc.java;

@FunctionalInterface
public interface NumberComparableOperator<T extends Number & Comparable<T>>
    extends ExpressionOperator<T> {}
