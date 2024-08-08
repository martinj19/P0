package com.revature;

import com.revature.controllers.MangaController;
import com.revature.controllers.OwnerController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {

    public static void main(String[] args) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFULL");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("...problem connecting to database...");
        }

        var app = Javalin.create()
                .start(3000)
                .get("/", ctx -> ctx.result("Hello Postman"));

        OwnerController oc = new OwnerController();
        MangaController mc = new MangaController();

        app.get("/owner", oc.getOwnerHandler);

        app.post("/owner", oc.insertOwnerHandler);

        app.patch("/manga/{id}", mc.updateMangaHandler);

        app.post("/manga", mc.insertManga);

        app.post("/manga/delete", mc.deleteManga);

        app.get("/manga", mc.getManga);

        app.post("/owner/delete", oc.deleteOwnerHandler);

        app.get("/owner/items", oc.getItemsHandler);

    }

}
