package com.example.cell_sim_but_different;

import com.example.cell_sim_but_different.particle.Identity;
import com.example.cell_sim_but_different.particle.Particle;

import java.util.concurrent.ThreadLocalRandom;

import static com.example.cell_sim_but_different.ParticlePane.*;

public class Tools {
    static int x, y;
    public static void addParticle(int[] coord, Identity identity) {
        x = coord[0];
        y = coord[1];
        if (x > Controller.size || y > Controller.size || y < 0 || x < 0) {
            return;
        }
        if (particleMap.get(coords[x][y]) != null) {
            return;
        }
        switch(identity) {
            case AIR -> particleMap.put(coords[x][y], new Particle(Identity.AIR));
            case WATER -> particleMap.put(coords[x][y], new Particle(Identity.WATER));
            case SAND -> particleMap.put(coords[x][y], new Particle(Identity.SAND));
        }
        Controller.particlePane.getChildren().add(particleMap.get(coords[x][y]).getRectangle());
        particleMap.get(coords[x][y]).setPosition(x, y);
    }

    public static void removeParticle(int[] coords, Particle p) {
        particleMap.remove(coords, p);
    }

    public static int generateRandom(int min, int max) {
        //i took this code from stack overflow trying to find the old method that i did it that i couldn't quite
        //remember, the max bound needs to be one more than the max bound you intend. this method of
        //getting a random int has the upside of not creating a .random instance.
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
