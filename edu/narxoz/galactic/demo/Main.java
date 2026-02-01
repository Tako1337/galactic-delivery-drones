package edu.narxoz.galactic.demo;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.*;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.*;
import edu.narxoz.galactic.dispatcher.*;

public class Main {
    public static void main(String[] args) {

        Planet earth = new Planet("Earth",0,0,"Oxygen");
        SpaceStation mars = new SpaceStation("Mars",100,0,2);

        Cargo cargo = new Cargo(20,"Food");

        LightDrone light = new LightDrone("L1",10);
        HeavyDrone heavy = new HeavyDrone("H1",50);

        DeliveryTask task = new DeliveryTask(earth,mars,cargo);
        Dispatcher dispatcher = new Dispatcher();

        System.out.println(dispatcher.assignTask(task, light));
        System.out.println(dispatcher.assignTask(task, heavy));
        System.out.println("Time: " + task.estimateTime());
        System.out.println(dispatcher.completeTask(task));
        System.out.println(task.getState());
        System.out.println(heavy.getStatus());
    }
}
