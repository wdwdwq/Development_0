package org.example;

import org.example.controller.MotivationController;
import org.example.controller.SystemController;
import org.example.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;//public 모든 클래에서 쓰는
    }


    public void run() {
        System.out.println("==Motivation Start==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);


        List<Motivation> ms = new ArrayList<>();
        while (true) { // 무한 루프
            System.out.print("command )");
            String cmd = sc.nextLine().trim();
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
