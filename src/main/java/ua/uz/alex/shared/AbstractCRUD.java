package ua.uz.alex.shared;

import java.util.List;

public interface AbstractCRUD<T>{

    T create(T t);
    T read(Integer id);
    T read(String email);
    T update(T t);
    void delete(Integer id);
    List<T> readAll();

}
