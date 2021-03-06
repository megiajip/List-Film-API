package com.example.myapplication.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myapplication.Injection;
import com.example.myapplication.R;
import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.main.MainContract;
import com.example.myapplication.main.MainPresenter;
import com.example.myapplication.model.Movies;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.rv_movies)
    RecyclerView recyclerView;

    private ProgressDialog progressDialog;
    private MovieAdapter adapter;
    private List<Movies> moviesList = new ArrayList<>();

    private MainPresenter mainPresenter = new MainPresenter(Injection.provideRepository(), this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainPresenter.getDataListMovies();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new MovieAdapter(getApplicationContext(), moviesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setTitle("Harap tunggu");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDataList(List<Movies> moviesList) {
        this.moviesList.addAll(moviesList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
