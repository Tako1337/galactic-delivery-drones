package edu.narxoz.galactic.dispatcher;

import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.*;

public class Dispatcher {

    public Result assignTask(DeliveryTask task, Drone drone) {
        if (task == null || drone == null)
            return new Result(false,"Null");

        if (task.getState() != TaskState.CREATED)
            return new Result(false,"Task not created");

        if (drone.getStatus() != DroneStatus.IDLE)
            return new Result(false,"Drone not idle");

        if (task.getCargo().getWeightKg() > drone.getMaxPayloadKg())
            return new Result(false,"Too heavy");

        task.setAssignedDrone(drone);
        task.setState(TaskState.ASSIGNED);
        drone.setStatus(DroneStatus.IN_FLIGHT);

        return new Result(true,"");
    }

    public Result completeTask(DeliveryTask task) {
        if (task == null)
            return new Result(false,"Null");

        if (task.getState() != TaskState.ASSIGNED)
            return new Result(false,"Not assigned");

        if (task.getAssignedDrone() == null)
            return new Result(false,"No drone");

        if (task.getAssignedDrone().getStatus() != DroneStatus.IN_FLIGHT)
            return new Result(false,"Drone not flying");

        task.setState(TaskState.DONE);
        task.getAssignedDrone().setStatus(DroneStatus.IDLE);

        return new Result(true,"");
    }
}
