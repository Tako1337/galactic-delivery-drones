package edu.narxoz.galactic.drones;

public abstract class Drone {

    private final String id;
    private final double maxPayloadKg;
    private DroneStatus status;

    protected Drone(String id, double maxPayloadKg) {
        if (maxPayloadKg <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.maxPayloadKg = maxPayloadKg;
        this.status = DroneStatus.IDLE;
    }

    public String getId() {
        return id;
    }

    public DroneStatus getStatus() {
        return status;
    }

    public double getMaxPayloadKg() {
        return maxPayloadKg;
    }

    public void setStatus(DroneStatus status) {
        this.status = status;
    }

    public abstract double speedKmPerMin();

    public static Drone createDrone(String type, String id, double maxPayloadKg) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        if (type.equalsIgnoreCase("LIGHT")) {
            return new LightDrone(id, maxPayloadKg);
        }
        if (type.equalsIgnoreCase("HEAVY")) {
            return new HeavyDrone(id, maxPayloadKg);
        }

        throw new IllegalArgumentException("Unknown drone type: " + type);
    }
}
