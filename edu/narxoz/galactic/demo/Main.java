package edu.narxoz.galactic.demo;

import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main {
    public static void main(String[] args) {

        GalacticFactory factory = new DefaultGalacticFactory();

        Planet earth = factory.createPlanet("Earth", 0, 0, "Oxygen");
        SpaceStation marsStation = factory.createStation("Mars Station", 100, 0, 3);

        Cargo cargo = factory.createCargo(20, "Food");

        DeliveryTask task = factory.createTask(earth, marsStation, cargo);

        Drone light = factory.createLightDrone("L1", 10);
        Drone heavy = factory.createHeavyDrone("H1", 50);

        Dispatcher dispatcher = new Dispatcher();

        System.out.println("1) Assign to LightDrone:");
        System.out.println(dispatcher.assignTask(light, task));

        System.out.println("2) Assign to HeavyDrone:");
        System.out.println(dispatcher.assignTask(heavy, task));

        System.out.println("3) Estimated time:");
        System.out.println(dispatcher.estimateTime(heavy, 100)
);

        System.out.println("4) Complete:");
        dispatcher.completeTask(heavy, task);
        System.out.println();
        System.out.println("Final task state: " + task.getState());
        System.out.println("Final drone status: " + heavy.getStatus());
    }
}

interface GalacticFactory {
    Planet createPlanet(String name, double x, double y, String atmosphereType);
    SpaceStation createStation(String name, double x, double y, int level);

    Drone createLightDrone(String id, double maxPayloadKg);
    Drone createHeavyDrone(String id, double maxPayloadKg);

    Cargo createCargo(double weightKg, String description);

    DeliveryTask createTask(Planet origin, SpaceStation destination, Cargo cargo);
}

class DefaultGalacticFactory implements GalacticFactory {

    @Override
    public Planet createPlanet(String name, double x, double y, String atmosphereType) {
        return new Planet(name, x, y, atmosphereType);
    }

    @Override
    public SpaceStation createStation(String name, double x, double y, int level) {
        return new SpaceStation(name, x, y, level);
    }

    @Override
    public Drone createLightDrone(String id, double maxPayloadKg) {
      
        return Drone.createDrone("LIGHT", id, maxPayloadKg);
    }

    @Override
    public Drone createHeavyDrone(String id, double maxPayloadKg) {
        return Drone.createDrone("HEAVY", id, maxPayloadKg);
    }

    @Override
    public Cargo createCargo(double weightKg, String description) {
        return new Cargo(weightKg, description);
    }

    @Override
    public DeliveryTask createTask(Planet origin, SpaceStation destination, Cargo cargo) {
        return new DeliveryTask(origin, destination, cargo);
    }
}
