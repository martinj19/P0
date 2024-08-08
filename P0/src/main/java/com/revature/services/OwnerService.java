package com.revature.services;

import com.revature.DAOs.OwnerDAO;
import com.revature.models.Owner;

import java.util.ArrayList;

public class OwnerService {


    OwnerDAO oDAO = new OwnerDAO();
    public ArrayList<Owner> getOwners() {

        return oDAO.getOwners();
    }

    public Owner insertOwner(Owner owner) throws IllegalArgumentException{
        if (owner.getOwner_name() == null || owner.getOwner_name().equals("")) {
            throw new IllegalArgumentException("Name can't be empty or null");
        }
        if (owner.getManga_id_fk() <= 0) {
            throw new IllegalArgumentException("Manga ID must be positive");
        }

        oDAO.insertOwner(owner);


        return owner;
    }

    public int deleteOwner(int owner_id) throws IllegalArgumentException{
        if (owner_id <= 0) {
            throw new IllegalArgumentException("Please enter a valid ID");
        }

        oDAO.deleteOwner(owner_id);

        return owner_id;
    }

    public ArrayList<Owner> getItems(String owner_name) throws IllegalArgumentException {
        if (owner_name == null || owner_name.equals("")) {
            throw new IllegalArgumentException("Please enter a valid name");
        }

        return oDAO.getItems(owner_name);


    }

}
