package com.company.web.dao;

import java.util.List;

public interface BlacklistDAO<T> {

    public void add(T obj);

    public T get(T obj);

    public boolean delete(T obj);

    public List<T> findAll();
}
