public interface Service<T> {
    boolean add(T item);
    boolean edit(T item);
    boolean remove(T item);
}
