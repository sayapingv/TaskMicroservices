package com.grsa.byemicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counters")
public class Counter {

    @Id
    private String name;

    @Column
    private Integer count;

    public Counter() {
    }

    public Counter(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getKey() {
        return name;
    }

    public void setKey(String key) {
        this.name = key;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
