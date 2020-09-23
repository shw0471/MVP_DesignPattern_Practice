package com.example.mvpdesignpatternpractice.Presenter;

import android.content.Context;

import com.example.mvpdesignpatternpractice.Contract.MainContract;
import com.example.mvpdesignpatternpractice.Model.Human;
import com.example.mvpdesignpatternpractice.Model.MainModel;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.View view, Context context) {
        this.view = view;
        model = new MainModel(this, context);
    }


    @Override
    public void getList() {
        view.setRecyclerView(model.getList());
    }

    @Override
    public void addHuman(Human human) {
        model.addData(human);
        view.addRecyclerView(model.getList());
    }
}