package com.revature.models;

public class Owner {

    private int owner_id;
    private String owner_name;
    private Manga manga;
    private int manga_id_fk;

    public Owner() {
    }

    public Owner(int owner_id, String owner_name, Manga manga) {
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.manga = manga;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public int getManga_id_fk() {
        return manga_id_fk;
    }

    public void setManga_id_fk(int manga_id_fk) {
        this.manga_id_fk = manga_id_fk;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "owner_id=" + owner_id +
                ", owner_name='" + owner_name + '\'' +
                ", manga=" + manga +
                '}';
    }
}
