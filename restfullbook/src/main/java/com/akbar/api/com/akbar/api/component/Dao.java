package com.akbar.api.com.akbar.api.component;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

        T get(Serializable var1);

        List<T> getAll();

        void save(T var1);

        void update(T var1);

        void delete(T var1);

}
