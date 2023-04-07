package com.example.cell_sim_but_different.particle;

import com.example.cell_sim_but_different.Rules;
import com.example.cell_sim_but_different.Tools;
import com.example.cell_sim_but_different.Update;
import javafx.scene.paint.Color;

import static com.example.cell_sim_but_different.ParticlePane.coords;
import static com.example.cell_sim_but_different.ParticlePane.particleMap;

public enum Identity {
    WATER(Color.BLUE, new Properties[]{Properties.NONSOLID}) {
        @Override
        public void move(int[] key) {
            particleMap.get(coords[key[0]][key[1]]).toggleFalling(Rules.checkCell(key[0], key[1], 0, 1));
            if (particleMap.get(coords[key[0]][key[1]]).getFalling() == true) {
                key = Rules.moveMultiple(coords[key[0]][key[1]], Update.weatherDirection * Update.weatherStrength, 1, 4);
                //key = Rules.moveMultiple(coords[key[0]][key[1]], Update.weatherDirection, 0, Update.weatherStrength);
            }
            else {
                if (Tools.generateRandom(0, 1) == 1) {
                    Rules.moveDirection(coords[key[0]][key[1]], 1, 0);
                }
                else {
                    Rules.moveDirection(coords[key[0]][key[1]], -1, 0);
                }
            }
        }
    }
    ,
    AIR(Color.ALICEBLUE, new Properties[]{Properties.GAS}) {
        @Override
        public void move(int[] key) {
        }
    }
    ,
    SAND(Color.BISQUE, new Properties[]{Properties.SOLID}) {
        @Override
        public void move(int[] key) {
            key = Rules.moveMultiple(coords[key[0]][key[1]], 0, 1, 4);
            if (!Rules.checkCell(key[0], key[1], 0, 1)) {
                if (Tools.generateRandom(0, 1) == 0) {
                    Rules.moveDirection(coords[key[0]][key[1]], 1, 1);
                }
                else {
                    Rules.moveDirection(coords[key[0]][key[1]], -1, 1);
                }
            }
        }
    }
    ;

    private Properties[] properties;
    Color c;

    Identity(Color c, Properties[] props) {
        properties = props;
        this.c = c;
    }

    public abstract void move(int[] key);

    public Color getColor() {
        return c;
    }


    public Properties[] getProperties() {
        return properties;
    }
}
