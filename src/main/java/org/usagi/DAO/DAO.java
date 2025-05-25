package org.usagi.DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(String id);
    
    List<T> getAll();

    int save(T t);

    int update(T t, T updateValue);

    int delete(T t);
}
