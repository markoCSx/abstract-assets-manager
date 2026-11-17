package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal value = BigDecimal.ZERO;
        BigDecimal squareFoot = BigDecimal.valueOf(getSquareFoot());
        BigDecimal excellentConditionCost = new BigDecimal("180.00");
        BigDecimal goodConditionCost = new BigDecimal("130.00");
        BigDecimal fairConditionCost = new BigDecimal("90.00");
        BigDecimal poorConditionCost = new BigDecimal("80.00");
        BigDecimal lotSizeCostPerSqFoot = new BigDecimal("0.25");
        BigDecimal lotSizeCost = lotSizeCostPerSqFoot.multiply(BigDecimal.valueOf(getLotSize()));
        switch (condition) {
            case 1 -> {
                value = value.add(excellentConditionCost.multiply(squareFoot));
            }
            case 2 -> {
                value = value.add(goodConditionCost.multiply(squareFoot));
            }
            case 3 -> {
                value = value.add(fairConditionCost.multiply(squareFoot));
            }
            case 4 -> {
                value = value.add(poorConditionCost.multiply(squareFoot));
            }
            default -> {
                return null;
            }
        }
        value = value.add(lotSizeCost);
        return value;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
