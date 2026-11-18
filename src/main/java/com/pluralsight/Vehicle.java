package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public Vehicle(){

    }

    @Override
    public BigDecimal getValue () {
        LocalDate now = LocalDate.now();
        BigDecimal bigYears = BigDecimal.valueOf(now.getYear()).subtract(BigDecimal.valueOf(getYear()));
        int years = Integer.parseInt(String.format("%f", bigYears));

        int vehicleCondition = 0;
        BigDecimal reducedValuePerYear = BigDecimal.ZERO;
        BigDecimal value = getOriginalCost();

        if (years <= 3) {
            vehicleCondition = 1;
            reducedValuePerYear = BigDecimal.valueOf(0.03).multiply(bigYears);
        } else if (years <= 6) {
            vehicleCondition = 2;
            reducedValuePerYear = BigDecimal.valueOf(0.06).multiply(bigYears);
        } else if (years <= 10) {
            vehicleCondition = 3;
            reducedValuePerYear = BigDecimal.valueOf(0.08).multiply(bigYears);
        } else {
            vehicleCondition = 4;
            reducedValuePerYear = new BigDecimal("1000");
        }

        switch (vehicleCondition) {
            case 1 -> {
                value = value.multiply((BigDecimal.ONE.subtract(reducedValuePerYear)));
            }
            case 2 -> {
                value = value.multiply((BigDecimal.ONE.subtract(reducedValuePerYear)));
            }
            case 3 -> {
                value = value.multiply((BigDecimal.ONE.subtract(reducedValuePerYear)));
            }
            case 4 -> {
                value = value.subtract(reducedValuePerYear);
            }
            default -> {
                return null;
            }
        }

        if ((!getMakeModel().toLowerCase().contains("honda") || !getMakeModel().toLowerCase().contains("toyota")) && this.odometer > 100_000) {
            value = value.multiply(BigDecimal.valueOf(0.75));
        }
        return value;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
