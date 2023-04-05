package com.example.cell_sim_but_different.particle;

import com.example.cell_sim_but_different.Identity;
import com.example.cell_sim_but_different.Properties;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Particle {
    private final Rectangle r;
    private Color c;
    private Identity identity;
    private Properties[] properties;
    private int x, y;

    public Particle(int size, Color c, Identity identity, Properties[] prop, int x, int y) {
        this.r = new Rectangle(size, size);
        this.c = c;
        this.identity = identity;
        this.properties = prop;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRectangle() {
        return r;
    }

    public Color getColor() {
        return c;
    }

    public Identity getIdentity() {
        return identity;
    }

    public Properties[] getProperties() {
        return properties;
    }

    public void setColor (Color c) {
        this.c = c;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public void setProperties(Properties[] properties) {
        this.properties = properties;
    }
}
