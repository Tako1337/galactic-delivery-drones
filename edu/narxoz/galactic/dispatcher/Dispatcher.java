package edu.narxoz.galactic.dispatcher;

import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.*;

public class Dispatcher {

    public Result assignTask(Drone heavy, DeliveryTask task) {

        if (heavy.getStatus() != DroneStatus.IDLE) {
            return new Result(false, "Drone is busy");
        }

        if (task.getCargo().getWeightKg() > heavy.getMaxPayloadKg()) {
            task.setState(TaskState.FAILED);
            return new Result(false, "Cargo too heavy");
        }

        heavy.setStatus(DroneStatus.IN_FLIGHT);
        task.setState(TaskState.ASSIGNED);

        return new Result(true, "Task assigned");
    }

    public double estimateTime(Drone heavy, double distanceKm) {
        return distanceKm / heavy.speedKmPerMin();
    }

    public void completeTask(Drone drone, DeliveryTask task) {
        drone.setStatus(DroneStatus.IDLE);
        task.setState(TaskState.DONE);
    }
}
