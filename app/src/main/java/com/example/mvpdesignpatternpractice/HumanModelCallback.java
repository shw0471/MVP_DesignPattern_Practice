package com.example.mvpdesignpatternpractice;

import com.example.mvpdesignpatternpractice.model.Human;

import java.util.List;

public interface HumanModelCallback {
    void setList(List<Human> humanList);
}