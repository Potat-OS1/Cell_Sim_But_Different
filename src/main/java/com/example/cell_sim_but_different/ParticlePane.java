package com.example.cell_sim_but_different;

import com.example.cell_sim_but_different.particle.Particle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class ParticlePane {
    public static ArrayList<Particle> particleArray = new ArrayList<>();
    public static Rectangle[][] rectangleArray;
    public static int rectSize;

    public static void initialize(int screenSize, int size) {
        rectSize = (int) Math.ceil(screenSize/size);


        Tools.addParticle(size-4, size-4, Identity.WATER);
        Tools.addParticle(size-3, size-4, Identity.SAND);
        Tools.addParticle(size-3, size-3, Identity.AIR);
    }
}
