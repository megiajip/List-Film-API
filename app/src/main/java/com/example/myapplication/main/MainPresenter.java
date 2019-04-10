package com.example.myapplication.main;

import com.example.myapplication.data.MovieDataSource;
import com.example.myapplication.data.MovieRepository;
import com.example.myapplication.model.Movies;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MovieRepository repository;
    private MainContract.View view;

    public MainPresenter (MovieRepository repository, MainContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getDataListMovies() {
        view.showProgress();
        repository.getListMovies(new MovieDataSource.GetListMoviesCallback() {
            @Override
            public void onSuccess(List<Movies> data) {
                view.hideProgress();
                view.showDataList(data);
            }

            @Override
            public void onFailed(String errorMessage) {
                view.hideProgress();
                view.showFailureMessage(errorMessage);
            }
        });
    }
}
