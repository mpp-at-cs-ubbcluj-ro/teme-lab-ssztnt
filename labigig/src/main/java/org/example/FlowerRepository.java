// FlowerRepository.java
package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlowerRepository {
    public void addFlower(Flower flower) throws SQLException {
        String sql = "INSERT INTO flowersss (name, color) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, flower.getName());
            pstmt.setString(2, flower.getColor());
            pstmt.executeUpdate();
        }
    }

    public List<Flower> getAllFlowers() throws SQLException {
        String sql = "SELECT * FROM flowersss";
        List<Flower> flowers = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Flower flower = new Flower();
                flower.setId(rs.getInt("id"));
                flower.setName(rs.getString("name"));
                flower.setColor(rs.getString("color"));
                flowers.add(flower);
            }
        }
        return flowers;
    }

    public void updateFlower(Flower flowerToUpdate) {
    }

    public List<Flower> getFlowersByColor(String color) throws SQLException {
        String sql = "SELECT * FROM flowersss WHERE color = ?";
        List<Flower> flowers = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, color);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Flower flower = new Flower();
                    flower.setId(rs.getInt("id"));
                    flower.setName(rs.getString("name"));
                    flower.setColor(rs.getString("color"));
                    flowers.add(flower);
                }
            }
        }
        return flowers;
    }


}