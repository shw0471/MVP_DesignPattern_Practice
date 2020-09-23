package com.example.mvpdesignpatternpractice.Model;

import android.content.Context;

import com.example.mvpdesignpatternpractice.Contract.MainContract;

import java.util.List;

import io.realm.Realm;

public class MainModel implements MainContract.Model {

    Realm realm;
    MainContract.Presenter presenter;

    Human human;

    public MainModel(MainContract.Presenter presenter, Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        this.presenter = presenter;
    }

    @Override
    public List<Human> getList() {
        return realm.where(Human.class).findAll();
    }

    @Override
    public void addData(Human human) {
        realm.beginTransaction();
        this.human = realm.createObject(Human.class);
        this.human.setName(human.getName());
        this.human.setAge(human.getAge());
        realm.commitTransaction();
    }
}