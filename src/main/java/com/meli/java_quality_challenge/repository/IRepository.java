package com.meli.java_quality_challenge.repository;

import java.util.List;
import java.util.UUID;

public interface IRepository<T> {
    List<T> create(List<T> type);
    T create(T type);
    List<T> read(UUID id);
    T read();
    Boolean update(T type);
    Boolean delete(UUID id);
}