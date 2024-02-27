package  mylibrarysystem.SingletonObserverDAO;

public abstract class DAO<T> {
    abstract void insert(T entity);
    abstract T select(int id);
    abstract void delete(int id);
    abstract void update(T entity);
}