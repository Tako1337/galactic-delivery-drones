package edu.narxoz.galactic.drones;

public class HeavyDrone extends Drone {
    public HeavyDrone(String id, double maxPayloadKg) {
        super(id, maxPayloadKg);
    }

    public double speedKmPerMin() {
        return 5.0;
    }
}
