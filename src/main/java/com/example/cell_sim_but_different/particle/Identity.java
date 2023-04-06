package com.example.cell_sim_but_different.particle;

import com.example.cell_sim_but_different.Rules;
import javafx.scene.paint.Color;

public enum Identity {
    WATER(Color.BLUE, new Properties[]{Properties.NONSOLID}) {
        @Override
        public void move(int[] key) {
            Rules.moveDirection(key, 0, 1);
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
