package HW1.Actions;

import HW1.Obstacles.Bike;
import HW1.Obstacles.Obstacle;

public class BikeAction implements PlayerAction {
    private int maxDistance;
    private ActionState actionState;

    public BikeAction(int maxDistance) {
        this.maxDistance = maxDistance;
        actionState = ActionState.NONE;
    }

    @Override
    public void pass(Obstacle obstacle) {
        if (obstacle instanceof Bike) {
            Bike bike = (Bike) obstacle;
            if (bike.getDistance() <= maxDistance) {
                System.out.println("Игрок проехал.");
                actionState = ActionState.VICTORY;
            } else {
                System.out.println("Игрок не смог проехать дистанцию. Может преодолеть максимум: " + maxDistance);
                actionState = ActionState.DEFEAT;
            }
        }
    }

    @Override
    public void pass(Obstacle[] obstacle) {

    }

    @Override

    public ActionState getActionState() { return actionState; }
}
