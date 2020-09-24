package com.example.mvpdesignpatternpractice.contract;

import com.example.mvpdesignpatternpractice.model.Human;

import java.util.List;

public class MainContract {

    public interface View {
        void setHumanList(List<Human> humanList);

        void addHuman(Human human);
    }

    public interface Presenter {
        void getList();

        void addHuman(Human human);
    }
}