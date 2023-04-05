package com.example.cell_sim_but_different;

import com.example.cell_sim_but_different.particle.Particle;
import javafx.scene.paint.Color;

import static com.example.cell_sim_but_different.ParticlePane.*;

public class Tools {
    public static void addParticle(int x, int y, Identity identity) {
        switch(identity) {
            case AIR -> particleArray.add(new Particle(rectSize, Color.ALICEBLUE, Identity.AIR, new Properties[]{Properties.GAS}, x, y));
            case WATER -> particleArray.add(new Particle(rectSize, Color.BLUE, Identity.WATER, new Properties[]{Properties.NONSOLID}, x, y));
            case SAND -> particleArray.add(new Particle(rectSize, Color.BEIGE, Identity.SAND, new Properties[]{Properties.SOLID}, x, y));
        }
    }

    public static void removeParticle(Particle p, int x, int y) {
        particleArray.remove(p);
        rectangleArray[x][y] = null;
    }
}
