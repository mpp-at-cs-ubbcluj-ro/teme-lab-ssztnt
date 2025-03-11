// Main.java
package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        FlowerRepository repository = new FlowerRepository();

        // Add a new flower
        Flower newFlower = new Flower();
        newFlower.setName("Rose");
        newFlower.setColor("Red");
        newFlower.setName("aaa");
        newFlower.setColor("Blue");
        newFlower.setName("bbb");
        newFlower.setColor("aaaa");
        newFlower.setName("ccccc");
        newFlower.setColor("DADADA");
        try {
            repository.addFlower(newFlower);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update an existing flower
        try {
            List<Flower> flowers = repository.getAllFlowers();
            if (!flowers.isEmpty()) {
                Flower flowerToUpdate = flowers.get(0);
                flowerToUpdate.setColor("Pink");
                repository.updateFlower(flowerToUpdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Print all flowers with a specific condition
        List<Flower> redFlowers = repository.getFlowersByColor("DADADA");
        for (Flower flower : redFlowers) {
            System.out.println("ID: " + flower.getId() + ", Name: " + flower.getName() + ", Color: " + flower.getColor());
        }

        List<Flower> allFlowers = repository.getAllFlowers();
        for (Flower flower : allFlowers) {
            System.out.println("ID: " + flower.getId() + ", Name: " + flower.getName() + ", Color: " + flower.getColor());
        }
    }

}