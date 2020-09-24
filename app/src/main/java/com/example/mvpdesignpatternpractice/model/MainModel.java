package com.example.mvpdesignpatternpractice.model;

import com.example.mvpdesignpatternpractice.HumanModelCallback;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainModel {

    Realm realm;
    Human human;
    private HumanModelCallback callback;

    public MainModel(HumanModelCallback callback) {
        realm = Realm.getDefaultInstance();
        this.callback = callback;
    }

    public void getList() {
        List<Human> humanList = new ArrayList<>();
        humanList.addAll(realm.where(Human.class).findAll());

        callback.setList(humanList);
    }

    public void addData(Human human) {
        realm.beginTransaction();
        this.human = realm.createObject(Human.class);
        this.human.setName(human.getName());
        this.human.setAge(human.getAge());
        realm.commitTransaction();
    }
}