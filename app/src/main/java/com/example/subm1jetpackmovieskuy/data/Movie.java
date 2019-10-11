package com.example.subm1jetpackmovieskuy.data;

public class Movie {
    public Float popularity;
    public Integer voteCount;
    public Boolean video;
    public String posterPath;
    public Integer id;
    public Boolean adult;
    public String backdropPath;
    public String originalLanguage;
    public String originalTitle;
    public String title;
    public Float voteAverage;
    public String overview;
    public String releaseDate;

    public Movie(double popularity, Integer voteCount, Boolean video, String posterPath, Integer id, boolean adult, String backdropPath, String originalLanguage, String originalTitle, String title, double voteAverage, String overview, String releaseDate) {
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.posterPath = posterPath;
        this.id = id;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }
}
