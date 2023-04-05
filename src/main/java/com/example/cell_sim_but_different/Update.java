package com.example.cell_sim_but_different;

import com.example.cell_sim_but_different.particle.Particle;
import javafx.animation.AnimationTimer;

import static com.example.cell_sim_but_different.ParticlePane.particleArray;

public class Update extends AnimationTimer {
    private long lastUpdate = 0;
    @Override
    public void handle(long now) {
        if (now - lastUpdate >= 3_000_000) {
            for (Particle a : particleArray) {
                if (a == null) {
                    continue;
                }
                a.getIdentity().move();
            }

            lastUpdate = now;
        }
    }
}
