package com.example.cell_sim_but_different.particle;

import com.example.cell_sim_but_different.ParticlePane;
import javafx.scene.shape.Rectangle;

public class Particle {
    Identity identity;
    double acceleration;
    private Rectangle r;
    private boolean moved;
    private boolean falling;

    public Particle(Identity i) {
        r = new Rectangle(ParticlePane.rectSize, ParticlePane.rectSize);
        r.setFill(i.getColor());
        identity = i;
        moved = false;
        click();
    }

    private void click() {
        r.setOnMouseClicked(Event->{
            System.out.println(identity + "  " + getRectangle().getLayoutX() + " " + getRectangle().getLayoutY() + "   " + moved);
        });
    }

    public boolean getFalling() {
        return falling;
    }

    public void toggleFalling(boolean b) {
        falling = b;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setMoved(Boolean bool) {
        moved = bool;
    }

    public boolean getMoved() {
        return moved;
    }

    public void setPosition(int x, int y) {
        r.setLayoutX(x*(r.getWidth()));
        r.setLayoutY(y*(r.getHeight()));
    }

    public void setIdentity(Identity i) {
        identity = i;
    }

    public Rectangle getRectangle() {
        return r;
    }
}
