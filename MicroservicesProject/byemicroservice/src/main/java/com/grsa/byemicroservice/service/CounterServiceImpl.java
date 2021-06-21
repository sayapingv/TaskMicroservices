package com.grsa.byemicroservice.service;

import com.grsa.byemicroservice.model.Counter;
import com.grsa.byemicroservice.repository.CounterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

    @Autowired
    private CounterDAO counterDAO;


    @Override
    public void increaseCounter(String key) {

        Counter counter = counterDAO.getCounter(key);
        if (counter == null) {
            counter = new Counter(key, 1);
        } else {
            counter.setCount(counter.getCount() + 1);
        }
        counterDAO.saveCounter(counter);
    }

    @Override
    public int getCount(String key) {
        Counter counter = counterDAO.getCounter(key);
        if (counter == null) {
            return 0;
        } else {
            return counter.getCount();
        }
    }
}
