package com.grsa.byemicroservice.service;

import com.grsa.byemicroservice.model.Counter;

public interface CounterService {

    void increaseCounter(String key);

    int getCount(String key);
}
