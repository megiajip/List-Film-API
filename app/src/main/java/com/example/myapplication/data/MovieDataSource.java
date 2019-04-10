package com.example.myapplication.data;

import com.example.myapplication.model.Movies;

import java.util.List;


public interface MovieDataSource {

    void getListMovies(GetListMoviesCallback callBack);

//    void getMoviesDetail(int userId, GetMoviesDetailCallback callback);

    interface GetListMoviesCallback {
        void onSuccess(List<Movies> data);

        void onFailed(String errorMessage);
    }

//    interface GetMoviesDetailCallback {
//        void onSuccess(Movies data);
//
//        void onFailed(String errorMessage);
//    }

}