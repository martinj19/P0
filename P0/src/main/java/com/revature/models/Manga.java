package com.revature.models;

public class Manga {

    private int manga_id;
    private String series;
    private String manga_name;
    private int volume;
    private String genre;

    public Manga() {
    }

    public Manga(int manga_id, String series, String manga_name, int volume, String genre) {
        this.manga_id = manga_id;
        this.series = series;
        this.manga_name = manga_name;
        this.volume = volume;
        this.genre = genre;
    }

    public int getManga_id() {
        return manga_id;
    }

    public void setManga_id(int manga_id) {
        this.manga_id = manga_id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getManga_name() {
        return manga_name;
    }

    public void setManga_name(String manga_name) {
        this.manga_name = manga_name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "manga_id=" + manga_id +
                ", series='" + series + '\'' +
                ", manga_name='" + manga_name + '\'' +
                ", volume=" + volume +
                ", genre='" + genre + '\'' +
                '}';
    }
}
