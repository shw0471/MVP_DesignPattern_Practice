package com.example.mvpdesignpatternpractice.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpdesignpatternpractice.R;
import com.example.mvpdesignpatternpractice.adapter.HumanListAdapter;
import com.example.mvpdesignpatternpractice.contract.MainContract;
import com.example.mvpdesignpatternpractice.model.Human;
import com.example.mvpdesignpatternpractice.presenter.MainPresenter;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    EditText et_name;
    EditText et_age;

    MainContract.Presenter mainPresenter;
    RecyclerView rv_humanList;
    HumanListAdapter humanListAdapter = new HumanListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        mainPresenter = new MainPresenter(this);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        Button btn_add = findViewById(R.id.btn_add);

        rv_humanList = findViewById(R.id.rv_humanList);
        rv_humanList.setAdapter(humanListAdapter);
        mainPresenter.getList();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_name.getText().length() < 1) return;
                if (et_age.getText().length() < 1) return;

                Human human = new Human();
                human.setName(String.valueOf(et_name.getText()));
                human.setAge(Integer.parseInt(String.valueOf(et_age.getText())));

                mainPresenter.addHuman(human);
            }
        });
    }

    @Override
    public void setHumanList(List<Human> humanList) {
        humanListAdapter.setHumanList(humanList);
    }

    @Override
    public void addHuman(Human human) {
        humanListAdapter.addHuman(human);
    }
}