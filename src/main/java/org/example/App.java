package org.example;

import org.example.controller.MotivationController;
import org.example.controller.SystemController;
import org.example.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class App {

    public void run() {
        System.out.println("==Motivation Start==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();


        while (true) { // 무한 루프
            System.out.print("command )");
            String cmd = Container.getScanner().nextLine().trim();
            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어 입력해");
                continue;
            }

            if (cmd.equals("add")) {
                motivationController.add();
            } else if (cmd.equals("list")) {
                motivationController.list();
            }

        }


    }
}
