package AI;

public interface Copyable<T extends Copyable<T>>
{
  public T copy();
}