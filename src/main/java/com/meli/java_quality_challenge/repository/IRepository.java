package com.meli.java_quality_challenge.repository;

import java.util.List;
import java.util.UUID;

public interface IRepository<T> {
    List<T> create(List<T> type);
    List<T> read();
    T read(UUID id);
    T update(T type);
    String delete(UUID id);
}
