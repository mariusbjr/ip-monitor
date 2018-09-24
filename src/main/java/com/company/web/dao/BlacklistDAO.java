package com.company.web.dao;

import java.util.List;
import java.util.Set;

public interface BlacklistDAO<T> {

    public void add(T obj);

    public T get(T obj);

    public boolean delete(T obj);

    public Set<T> findAll();
}
