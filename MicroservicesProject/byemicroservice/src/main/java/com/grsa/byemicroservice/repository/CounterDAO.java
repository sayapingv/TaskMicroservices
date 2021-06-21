package com.grsa.byemicroservice.repository;

import com.grsa.byemicroservice.model.Counter;

public interface CounterDAO {

    void saveCounter(Counter counter);

    Counter getCounter(String key);
}
