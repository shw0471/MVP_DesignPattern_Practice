package com.example.mvpdesignpatternpractice.Contract;

import com.example.mvpdesignpatternpractice.Model.Human;

import java.util.List;

public class MainContract {

    public interface View {
        void setRecyclerView(List<Human> humanList);

        void addRecyclerView(List<Human> humanList);
    }

    public interface Presenter {
        void getList();

        void addHuman(Human human);
    }

    public interface Model {
        List<Human> getList();

        void addData(Human human);
    }
}