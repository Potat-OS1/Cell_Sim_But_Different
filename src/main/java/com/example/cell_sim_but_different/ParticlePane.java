package com.example.cell_sim_but_different;

import com.example.cell_sim_but_different.particle.Identity;
import com.example.cell_sim_but_different.particle.Particle;

import java.util.HashMap;

public class ParticlePane {
    public static HashMap<int[], Particle> particleMap = new HashMap<>();
    public static int[][][] coords = new int[Controller.size][Controller.size][2];
    public static int rectSize;

    public static void initialize(int screenSize, int size) {
        rectSize = (int) Math.ceil(screenSize/size);
        int c;
        int d = 0;
        for (int[][] a : coords) {
            c = 0;
            for (int[] b : a) {
                b[0] = d;
                b[1] = c;
                // heh
                c++;
            }
            d++;
        }

//        for (int[][] a : coords) {
//            for (int [] b : a) {
//                particleMap.put(coords[b[0]][b[1]], new Particle(null));
//            }
//        }
    }
}
