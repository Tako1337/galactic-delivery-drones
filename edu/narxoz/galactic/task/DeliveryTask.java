package edu.narxoz.galactic.task;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;

public class DeliveryTask {

    private CelestialBody from;
    private CelestialBody to;
    private Cargo cargo;
    private TaskState state;

    public DeliveryTask(CelestialBody from, CelestialBody to, Cargo cargo) {
        this.from = from;
        this.to = to;
        this.cargo = cargo;
        this.state = TaskState.CREATED;
    }

    public CelestialBody getFrom() {
        return from;
    }

    public CelestialBody getTo() {
        return to;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }
}
