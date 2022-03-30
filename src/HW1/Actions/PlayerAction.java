package HW1.Actions;

import HW1.Obstacles.Obstacle;

public interface PlayerAction {
    void pass(Obstacle[] obstacle);

    void pass(Obstacle obstacle);

    ActionState getActionState();
}
