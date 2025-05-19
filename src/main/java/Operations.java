import java.util.List;

public interface Operations <T> {
    void create(T item);
    void read(int id);
    List<T> readAll();
    void update(T item);
    void delete(int id);
}
