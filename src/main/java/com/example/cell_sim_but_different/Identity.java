package com.example.cell_sim_but_different;

public enum Identity {
    WATER {
        @Override
        public void move() {
            System.out.println("Oi");
        }
    }
    ,
    SAND {
        @Override
        public void move() {
            System.out.println("Boi");
        }
    }
    ,
    AIR {
        @Override
        public void move() {
            System.out.println("Toi");
        }
    }
    ;

    abstract void move();

}
