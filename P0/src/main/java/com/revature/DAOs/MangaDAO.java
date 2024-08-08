package com.revature.DAOs;

import com.revature.models.Manga;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MangaDAO implements MangaDAOInterface{
    @Override
    public Manga getMangaById(int id) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from manga where manga_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Manga manga = new Manga(rs.getInt("manga_id"),
                        rs.getString("series"),
                        rs.getString("manga_name"),
                        rs.getInt("volume"),
                        rs.getString("genre"));

                return manga;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public String updateManga(int id, String series, String name, String volume, String genre) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "update manga set series = ?, manga_name = ?, volume = ?, genre = ? where manga_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, series);
            ps.setString(2, name);
            ps.setInt(3, Integer.parseInt(volume));
            ps.setString(4, genre);
            ps.setInt(5, id);
            ps.executeUpdate();


            return series + name + Integer.parseInt(volume) + genre;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't update series");
        }


        return null;
    }

    @Override
    public Manga insertManga(Manga manga) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into manga (series, manga_name, volume, genre) " +
                    "values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manga.getSeries());
            ps.setString(2, manga.getManga_name());
            ps.setInt(3, manga.getVolume());
            ps.setString(4, manga.getGenre());

            ps.executeUpdate();

            return manga;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't add new manga");
        }

        return null;
    }

    @Override
    public int deleteManga(int id) {



        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "delete from manga where manga_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            return id;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't delete manga");
        }

        return -1;
    }

    @Override
    public ArrayList<Manga> getMangaByKeyword(String keyword) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from manga where series like ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, keyword);
            ResultSet rs = ps.executeQuery();

            ArrayList<Manga> mangas = new ArrayList<>();

            while (rs.next()) {
                Manga manga = new Manga(rs.getInt("manga_id"),
                        rs.getString("series"),
                        rs.getString("manga_name"),
                        rs.getInt("volume"),
                        rs.getString("genre"));

                mangas.add(manga);
            } // end of while

            return mangas;


        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't find any manga");
        }

        return null;
    }
}
