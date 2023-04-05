package com.example.cell_sim_but_different;

import com.example.cell_sim_but_different.particle.Particle;

public class Rules extends ParticlePane{
    private int x, y;
    public void moveHorizontal(Particle p, int force) {
        x = p.getX();
        y = p.getY();

        if (rectangleArray[x+force][y] == null) {
            rectangleArray[x+force][y] = rectangleArray[x][y];
            rectangleArray[x][y] = null;
        }
        
    }
}
