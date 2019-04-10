package com.example.myapplication.main;

import com.example.myapplication.model.Movies;

import java.util.List;

public interface MainContract {

    interface View {
        void showProgress();
        void hideProgress();
        void showDataList(List<Movies> moviesList);
        void showFailureMessage(String msg);
    }

    interface Presenter {
        void getDataListMovies();
    }

}
