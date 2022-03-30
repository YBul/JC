package HW1;

import HW1.Actions.JumpAction;
import HW1.Actions.PlayerAction;
import HW1.Actions.RunAction;
import HW1.Actions.SwimAction;
import HW1.Actions.BikeAction;
import HW1.Obstacles.*;

import java.util.Random;

public class Main {
    private static final int POOL_DISTANCE = 100;
    private static final int RACETRACK_DISTANCE = 100;
    private static final int WALL_DISTANCE = 5;
    private static final int BIKE_DISTANCE = 500;

    public static void main(String[] args) {
        Course course = new Course(makeObstacles());
        Player[] players = makePlayers();
        Team team = new Team("Команда", players);
        course.doIt(team);
        team.printWinners();
    }

    public static Obstacle[] makeObstacles() {
        return new Obstacle[] {
                new Pool(POOL_DISTANCE),
                new Racetrack(RACETRACK_DISTANCE),
                new Wall(WALL_DISTANCE),
                new Bike(BIKE_DISTANCE)
        };
    }

    public static Player[] makePlayers() {
        return new Player[] {
                new Player("Сергей", new PlayerAction[] { getSwimAction(), getJumpAction(), getBikeAction() }),
                new Player("Алексей", new PlayerAction[] { getRunAction(), getBikeAction() }),
                new Player("Юлия", new PlayerAction[] { getSwimAction(), getRunAction(), getJumpAction() }),
                new Player("Алла", new PlayerAction[] { getSwimAction() }),
        };
    }

    public static PlayerAction getSwimAction() {
        Random random = new Random();
        SwimAction swimAction = new SwimAction(random.nextInt(POOL_DISTANCE + 50));
        return swimAction;
    }

    public static PlayerAction getJumpAction() {
        Random random = new Random();
        JumpAction jumpAction = new JumpAction(random.nextInt(WALL_DISTANCE + 2));
        return jumpAction;
    }

    public static PlayerAction getRunAction() {
        Random random = new Random();
        RunAction runAction = new RunAction(random.nextInt(RACETRACK_DISTANCE + 50));
        return runAction;
    }

    public static PlayerAction getBikeAction() {
        Random random = new Random();
        BikeAction bikeAction = new BikeAction(random.nextInt(BIKE_DISTANCE + 100));
        return bikeAction;
    }


}
