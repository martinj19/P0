package com.revature.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAOs.OwnerDAO;
import com.revature.models.Owner;
import com.revature.services.OwnerService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class OwnerController {



    OwnerService os = new OwnerService();
    ObjectMapper mapper = new ObjectMapper();

    public Handler getOwnerHandler = ctx -> {
        ArrayList<Owner> owners = os.getOwners();

        ctx.json(owners);

        ctx.status(200);
    };

    public Handler insertOwnerHandler = ctx -> {
        Owner newOwner = ctx.bodyAsClass(Owner.class);

        Owner insertedOwner;

        try {
            insertedOwner = os.insertOwner(newOwner);

            ctx.status(201);
            ctx.json(insertedOwner);

            ctx.result("Added new user...");

        } catch (IllegalArgumentException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        } catch (NullPointerException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        }
    };

    public Handler deleteOwnerHandler = ctx -> {

        try {

            int owner_id = Integer.parseInt(ctx.body());

            os.deleteOwner(owner_id);

            ctx.status(200);
            ctx.result("Deleted owner");

        }catch (IllegalArgumentException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        }


    };

    public Handler getItemsHandler = ctx -> {

        JsonNode jsonNode = mapper.readTree(ctx.body());
        String owner_name = jsonNode.get("owner_name").asText();
        ArrayList<Owner> owners = os.getItems(owner_name);
        ctx.json(owners);
        ctx.status(200);


    };

}
