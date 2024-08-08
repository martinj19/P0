package com.revature.controllers;

import com.revature.models.Manga;
import com.revature.services.MangaService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class MangaController {

    MangaService ms = new MangaService();


    public Handler updateMangaHandler = ctx -> {
        int manga_id = Integer.parseInt(ctx.pathParam("id"));
        Manga manga = ctx.bodyAsClass(Manga.class);

        try {
            ms.updateManga(manga_id, manga.getSeries(),manga.getManga_name(), String.valueOf(manga.getVolume()), manga.getGenre());
            ctx.status(202);
            ctx.result("Manga has been updated");
        } catch (IllegalArgumentException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        }


    };

    public Handler insertManga = ctx -> {

        Manga newManga = ctx.bodyAsClass(Manga.class);

        Manga insertedManga;

        try {
            insertedManga = ms.insertManga(newManga);

            ctx.status(201);
            ctx.json(insertedManga);
            ctx.result("Manga inserted");

        } catch (IllegalArgumentException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        } catch (NullPointerException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        }

    };

    public Handler deleteManga = ctx -> {

        int manga_id = Integer.parseInt(ctx.body());

        try {
            ms.deleteManga(manga_id);
            ctx.status(200);
            ctx.result("Manga deleted");

        } catch (IllegalArgumentException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        } catch (NullPointerException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        }

    };

    public Handler getManga = ctx -> {

        String keyword = ctx.body();

        ArrayList<Manga> mangas = ms.getMangaByKeyword(keyword);

        ctx.json(mangas);

        ctx.status(200);
    };

}
