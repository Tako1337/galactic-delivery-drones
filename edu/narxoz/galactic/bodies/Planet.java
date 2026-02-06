package edu.narxoz.galactic.bodies;

public class Planet extends CelestialBody {

    private String atmosphere;

    public Planet(String name, double x, double y, String atmosphere) {
        super(name, x, y);
        this.atmosphere = atmosphere;
    }

    public String getAtmosphere() {
        return atmosphere;
    }
}

