package HW1.Actions;

import HW1.Obstacles.Obstacle;
import HW1.Obstacles.Racetrack;

public class RunAction implements PlayerAction {
    private int maxDistance;
    private ActionState actionState;

    public RunAction(int maxDistance) {
        this.maxDistance = maxDistance;
        actionState = ActionState.NONE;
    }

    @Override
    public void pass(Obstacle obstacle) {
        if (obstacle instanceof Racetrack) {
            Racetrack racetrack = (Racetrack) obstacle;
            if (racetrack.getDistance() <= maxDistance) {
                System.out.println("Игрок пробежал.");
                actionState = ActionState.VICTORY;
            } else {
                System.out.println("Игрок не смог пробежать. Может пробежать максимум: " + maxDistance);
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
