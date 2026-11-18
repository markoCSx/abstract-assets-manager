package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        House house = new House("Vacation Base", "1999-04-29", new BigDecimal("500000"), "Middle of nowhere", 1, 2000, 600);
        assets.add(house);
        house = new House("Main Base", "2026-04-29", new BigDecimal("1000000"), "North of nowhere", 1, 2000, 600);
        assets.add(house);

        Vehicle vehicle = new Vehicle("Car", "1999-04-29", new BigDecimal("75000"), "Mazda|RX-3", 1974, 100001);
        assets.add(vehicle);
        vehicle = new Vehicle("Aerodyne", "2026-04-29", new BigDecimal("1000000"), "Zetatech|Prototype", 2026, 0);
        assets.add(vehicle);

        Cash mattress = new Cash("Money", "2026-04-29", new BigDecimal("1000"));
        assets.add(mattress);

        for ( Asset currentAsset : assets) {
            if (currentAsset instanceof House) {
                System.out.println(((House) currentAsset).getAddress());
            }
            if (currentAsset instanceof Vehicle) {
                System.out.println(((Vehicle) currentAsset).getYear() + "|" + ((Vehicle) currentAsset).getMakeModel());
            }
            System.out.println(currentAsset.getDescription());
            System.out.println(currentAsset.getDateAcquired());
            System.out.println(currentAsset.getOriginalCost());
            System.out.println(currentAsset.getValue());
        }
        //Asset test = new Asset();
    }
}
