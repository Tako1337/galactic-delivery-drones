package edu.narxoz.galactic.cargo;

public class Cargo {

    private String name;
    private double weightKg;

    public Cargo(double weightKg, String name) {
        this.name = name;
        this.weightKg = weightKg;
    }

    public String getName() {
        return name;
    }

    public double getWeightKg() {
        return weightKg;
    }
}

