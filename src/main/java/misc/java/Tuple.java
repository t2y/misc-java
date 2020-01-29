package misc.java;

import lombok.Getter;
import lombok.ToString;
import lombok.val;

@Getter
@ToString
public class Tuple<L, R> {

  private final L left;
  private final R right;

  public Tuple(L left, R right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public int hashCode() {
    return left.hashCode() ^ right.hashCode();
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (!(o instanceof Tuple)) return false;
    val t = (Tuple<L, R>) o;
    return this.left.equals(t.getLeft()) && this.right.equals(t.getRight());
  }
}
