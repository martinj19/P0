package com.revature.services;

import com.revature.DAOs.MangaDAO;
import com.revature.models.Manga;

import java.util.ArrayList;

public class MangaService {

    MangaDAO mDAO = new MangaDAO();

    public String updateManga(int id, String series, String name, String volume, String genre) {
        if (id <= 0) {
            throw new IllegalArgumentException("Manga ID must be positive");
        }
        if (mDAO.getMangaById(id) == null) {
            throw new IllegalArgumentException("Role ID doesn't exist");
        }

        return mDAO.updateManga(id, series, name, volume, genre);
    }

    public Manga insertManga(Manga manga) throws IllegalArgumentException {
        if (manga == null) {
            throw new IllegalArgumentException("You can't have null values");
        }
        if (manga.getSeries().equals("") || manga.getManga_name().equals("")
            || manga.getVolume() < 0 || manga.getGenre().equals("")) {

            throw new IllegalArgumentException("You can't have any empty values");
        }



        return mDAO.insertManga(manga);
    }

    public int deleteManga (int id) throws IllegalArgumentException {

        if (id <= 0) {
            throw new IllegalArgumentException("Manga ID has to be greater than 0 ");
        }

        return mDAO.deleteManga(id);

    }

    public ArrayList<Manga> getMangaByKeyword (String keyword) {
        return mDAO.getMangaByKeyword(keyword);
    }
}
