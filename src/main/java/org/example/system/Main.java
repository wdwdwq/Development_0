package org.example.system;

import org.example.system.system.Container;

public class Main {
    public static void main(String[] args) {
        Container.init();
        new App().run();

        Container.close();
    }
}
