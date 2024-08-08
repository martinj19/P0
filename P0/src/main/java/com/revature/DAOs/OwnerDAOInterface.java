package com.revature.DAOs;


import com.revature.models.Owner;

import java.util.ArrayList;

public interface OwnerDAOInterface {


    ArrayList<Owner> getOwners();

    Owner insertOwner(Owner owner);

    int deleteOwner(int owner_id);

    ArrayList<Owner> getItems(String owner_name);
}
