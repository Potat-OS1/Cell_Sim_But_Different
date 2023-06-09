package com.example.cell_sim_but_different;

import com.example.cell_sim_but_different.particle.Particle;
import com.example.cell_sim_but_different.particle.Properties;

public class Rules extends ParticlePane{
    private static int x, y;
    private static Particle neighbor, self;
    private static int[] temp;
    public static int[] moveDirection(int[] coord, int xForce, int yForce) {
        x = coord[0];
        y = coord[1];
        if (!checkCell(x, y , xForce, yForce)) {
            return coord;
        }

        neighbor = particleMap.get(coords[x+xForce][y+yForce]);
        particleMap.put(coords[x+xForce][y+yForce], particleMap.get(coords[x][y]));
        if (neighbor == null) {
            particleMap.put(coords[x][y], null);
            particleMap.get(coords[x+xForce][y+yForce]).setPosition(x+xForce, y+yForce);
        }
        else {
            particleMap.put(coords[x][y], neighbor);
            particleMap.get(coords[x][y]).setPosition(x, y);
            particleMap.get(coords[x+xForce][y+yForce]).setPosition(x+xForce, y+yForce);
        }
        return coords[x+xForce][y+yForce];
    }

    public static boolean checkCell(int x, int y, int xForce, int yForce) {
        // true in this context means you have the go ahead.
        if (x + xForce > Controller.size - 1 || x + xForce < 0 || y + yForce > Controller.size - 1 || y + yForce < 0) {
            return false;
        }
        neighbor = particleMap.get(coords[x+xForce][y+yForce]);
        if (neighbor == null) {
            return true;
        }
        self = particleMap.get(coords[x][y]);
        if (neighbor == self) {
            return false;
        }
        for (Properties p : self.getIdentity().getProperties()) {
            switch (p) {
                case SOLID -> {
                    if (caseCheck(Properties.SOLID, neighbor)) {
                        return false;
                    }
                }
                case NONSOLID -> {
                    if (caseCheck(Properties.SOLID, neighbor) || caseCheck(Properties.NONSOLID, neighbor)) {
                        return false;
                    }
                }
                case GAS -> {
                    if (caseCheck(Properties.NONSOLID, neighbor)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean caseCheck(Properties testCase, Particle tested) {
        for (Properties p : tested.getIdentity().getProperties()) {
            if (p == testCase) {
                return true;
            }
        }
        return false;
    }

    public static int[] moveMultiple(int[] coord, int xForce, int yForce, int reps) {
        if (reps > 0) {
            temp = moveDirection(coords[coord[0]][coord[1]], xForce, yForce);
            reps--;
            moveMultiple(coords[temp[0]][temp[1]], xForce, yForce, reps);
        }
        return coords[temp[0]][temp[1]];
    }
}
