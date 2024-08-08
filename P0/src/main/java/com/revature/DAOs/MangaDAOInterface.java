package com.revature.DAOs;

import com.revature.models.Manga;

import java.util.ArrayList;

public interface MangaDAOInterface {

    Manga getMangaById(int id);
    String updateManga(int id, String series, String name, String volume, String genre);
    Manga insertManga (Manga manga);
    int deleteManga (int id);
    ArrayList<Manga> getMangaByKeyword(String keyword);


}
