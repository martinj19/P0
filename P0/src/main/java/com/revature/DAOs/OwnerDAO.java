package com.revature.DAOs;

import com.revature.models.Manga;
import com.revature.models.Owner;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerDAO implements OwnerDAOInterface{
    @Override
    public ArrayList<Owner> getOwners() {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from owner";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Owner> owners = new ArrayList<>();
            while (rs.next()) {
                Owner o = new Owner(rs.getInt("owner_id"),
                        rs.getString("owner_name"),
                        null);

                MangaDAO mDAO = new MangaDAO();
                Manga manga = mDAO.getMangaById(rs.getInt("manga_id_fk"));
                o.setManga(manga);

                owners.add(o);
            }//end of while loop

            return owners;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Owner insertOwner(Owner owner) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into owner (owner_name, manga_id_fk) " +
                    "values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, owner.getOwner_name());
            ps.setInt(2, owner.getManga_id_fk());
            ps.executeUpdate();

            return owner;


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't insert new owner...");
        }

        return null;
    }

    @Override
    public int deleteOwner(int owner_id) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "delete from owner where owner_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, owner_id);
            ps.executeUpdate();

            return owner_id;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't delete owner...");
        }

        return -1;
    }

    @Override
    public ArrayList<Owner> getItems(String owner_name) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from owner where owner_name = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, owner_name);
            ResultSet rs = ps.executeQuery();

            ArrayList<Owner> owners = new ArrayList<>();
            while (rs.next()) {

                Owner owner = new Owner(rs.getInt("owner_id"),
                        rs.getString("owner_name"),
                        null);

                MangaDAO mDAO = new MangaDAO();
                Manga manga = mDAO.getMangaById(rs.getInt("manga_id_fk"));
                owner.setManga(manga);

                owners.add(owner);

            } //end of while


            return owners;

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't find owner...");
        }


        return null;
    }
}
