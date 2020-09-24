package com.example.mvpdesignpatternpractice.presenter;

import com.example.mvpdesignpatternpractice.Callback;
import com.example.mvpdesignpatternpractice.contract.MainContract;
import com.example.mvpdesignpatternpractice.model.Human;
import com.example.mvpdesignpatternpractice.model.MainModel;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainModel model;

    public MainPresenter(MainContract.View viewParam) {
        view = viewParam;
        model = new MainModel();

        model.setCallBack(new Callback() {
            @Override
            public void setList(List<Human> humanList) {
                view.setHumanList(humanList);
            }
        });
    }

    @Override
    public void getList() {
        model.getList();
    }

    @Override
    public void addHuman(Human human) {
        model.addData(human);
        view.addHuman(human);
    }
}