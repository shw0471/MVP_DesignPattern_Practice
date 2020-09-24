package com.example.mvpdesignpatternpractice;

import com.example.mvpdesignpatternpractice.model.Human;

import java.util.List;

public interface Callback {
    void setList(List<Human> humanList);
}