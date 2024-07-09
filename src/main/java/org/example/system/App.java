package org.example.system;

import org.example.controller.MotivationController;
import org.example.entity.Motivation;
import org.example.system.system.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {


    public void run() {
        System.out.println("==Motivation Start==");

        MotivationController motivationController = new MotivationController();
        while (true) {
            System.out.print("command ) ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("==Motivation exit==");
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
