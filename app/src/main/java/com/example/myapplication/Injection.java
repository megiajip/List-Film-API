package com.example.myapplication;

import com.example.myapplication.data.MovieRepository;
import com.example.myapplication.data.remote.MovieRemoteDataSource;

public class Injection {

    public static MovieRepository provideRepository() {
        return new MovieRepository(new MovieRemoteDataSource());
    }

}
