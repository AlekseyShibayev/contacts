package com.mycompany.app.Dao;

import java.util.List;

public interface Dao<T> {

    void create(T model);

    T read(Integer integer);

    void update(T model);

    void delete(Integer integer);

//    List<T> findAll();

}
