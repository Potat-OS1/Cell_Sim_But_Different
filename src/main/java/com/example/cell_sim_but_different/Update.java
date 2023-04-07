package com.example.cell_sim_but_different;

import com.example.cell_sim_but_different.particle.Identity;
import com.example.cell_sim_but_different.particle.Particle;
import javafx.animation.AnimationTimer;

import java.util.HashMap;

import static com.example.cell_sim_but_different.ParticlePane.coords;
import static com.example.cell_sim_but_different.ParticlePane.particleMap;

public class Update extends AnimationTimer {
    private long lastUpdate = 0;
    Particle temp;
    int randomPos;
    public boolean weather = true;
    public static int weatherStrength = 0;
    public static int weatherDirection = -1;
    @Override
    public void start() {
        lastUpdate = System.nanoTime();
        super.start();
    }

    @Override
    public void handle(long now) {
        if (now - lastUpdate >= 6_000_000) {
            System.out.println(now-lastUpdate);
            randomParticleRain(0);

            randomParticleRain(1);
            for (int[][] a : coords) {
                for (int[] b : a) {
                    temp = particleMap.get(b);
                    if (temp == null) {
                        continue;
                    }
                    if (temp.getMoved() == false) {
                        if (Tools.generateRandom(0, 1) == 0) {
                            updateWeather(true);
                        }
                        else {
                            updateWeather(false);
                        }
                        temp.getIdentity().move(b);
                        temp.setMoved(true);
                    }
                }
            }
//
            for (HashMap.Entry<int[], Particle> a : particleMap.entrySet()) {
                temp = a.getValue();
                if (temp == null) {
                    continue;
                }
                temp.setMoved(false);
            }
            lastUpdate = now;
        }
    }
    private void updateWeather(boolean addStrength) {
        if (addStrength) {
            if (weatherStrength <= 5) {
                weatherStrength++;
            }
        }
        else {
            if (weatherStrength > -5) {
                weatherStrength--;
            }
        }
    }
    private void randomParticleRain(int type) {
        randomPos = Tools.generateRandom(0, Controller.size-1);
        switch(type) {
            case (0) -> Tools.addParticle(coords[randomPos][0], Identity.WATER);
            case (1) -> Tools.addParticle(coords[randomPos][0], Identity.SAND);
        }

    }
}
