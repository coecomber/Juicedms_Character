package com.Herwaarden.Character.DAL.Context;

import com.Herwaarden.Character.DAL.Interface.Context.ICharacterContext;
import com.Herwaarden.Character.Model.Character.*;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterContextSQL implements ICharacterContext {
    private String sqlUrl;
    private String usernameUrl;
    private String passwordUrl;

    // Constructors
    public CharacterContextSQL(){
        sqlUrl = "jdbc:mysql://217.101.44.31/characterDB";
        usernameUrl = "root";
        passwordUrl = "varken";
    }

    // Methods
    @Override
    public List<CharacterModel> getMyCharacters(String email) {
        List<CharacterModel> characterModelList = new ArrayList<>();

        // create our mysql database connection
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "SELECT * FROM charactertable WHERE email = " + "'" + email + "'";

            // create the java statement
            try (PreparedStatement cst = conn.prepareCall(query))
            {
                try (ResultSet rs = cst.executeQuery(query))
                {
                    // iterate through the java resultset
                    while (rs.next())
                    {
                        CharacterModel characterModel = new CharacterModel();

                        characterModel.setId(rs.getInt("id"));
                        characterModel.setActive(rs.getString("active"));
                        characterModel.setCreatedAt(rs.getString("created"));
                        characterModel.setLastLoggedInAt(rs.getString("lastLoggedIn"));
                        characterModel.setGender(rs.getString("gender"));
                        characterModel.setName(rs.getString("name"));
                        characterModel.setEmail(rs.getString("email"));
                        characterModel.setFloor(rs.getInt("floor"));
                        characterModel.setPower(new BigInteger(Integer.valueOf(rs.getInt("power")).toString()));
                        characterModel.setGold(new BigInteger(Integer.valueOf(rs.getInt("gold")).toString()));

                        characterModelList.add(characterModel);
                    }
                }
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in CharacterContextSQL.getMyCharacters().");
            System.err.println(e.getMessage());
        }

        return characterModelList;
    }

    // Methods
    @Override
    public CharacterModel getCharacter(int id) {
        CharacterModel characterModel = new CharacterModel();

        // create our mysql database connection
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "SELECT * FROM charactertable WHERE id = " + id;

            // create the java statement
            try (PreparedStatement cst = conn.prepareCall(query))
            {
                try (ResultSet rs = cst.executeQuery(query))
                {
                    // iterate through the java resultset
                    while (rs.next())
                    {
                        characterModel.setId(rs.getInt("id"));
                        characterModel.setActive(rs.getString("active"));
                        characterModel.setCreatedAt(rs.getString("created"));
                        characterModel.setLastLoggedInAt(rs.getString("lastLoggedIn"));
                        characterModel.setGender(rs.getString("gender"));
                        characterModel.setName(rs.getString("name"));
                        characterModel.setEmail(rs.getString("email"));
                        characterModel.setFloor(rs.getInt("floor"));
                        characterModel.setPower(new BigInteger(Integer.valueOf(rs.getInt("power")).toString()));
                        characterModel.setGold(new BigInteger(Integer.valueOf(rs.getInt("gold")).toString()));
                    }
                }
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in CharacterContextSQL.getMyCharacters().");
            System.err.println(e.getMessage());
        }

        return characterModel;
    }

    @Override
    public boolean createCharacter(String name, String email) {
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "INSERT INTO charactertable(name, email) VALUES (?, ?);";

            try(PreparedStatement cst = conn.prepareStatement(query)){
                cst.setString(1, name);
                cst.setString(2, email);
                cst.executeUpdate();
                return true;
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in CharacterContextSQL.getMyCharacters().");
            System.err.println(e.getMessage());
        }

        return false;
    }
}
