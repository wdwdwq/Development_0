package org.example.controller;

import org.example.entity.Motivation;
import org.example.system.Container;
import org.example.system.Rq;

import java.util.ArrayList;
import java.util.List;

public class MotivationController {
    int lastId;
    List<Motivation> ms;

    public MotivationController() {
        lastId = 0;
        ms = new ArrayList<>();

    }

    public void add() {
        int id = lastId + 1;
        System.out.print("title : ");
        String title = Container.getScanner().nextLine().trim();
        System.out.print("body : ");
        String body = Container.getScanner().nextLine().trim();

        Motivation m = new Motivation(id, body, title);
        ms.add(m);

        System.out.printf("%d번 게시글이 등록 되었습니다\n", id);
        lastId++;
    }

    public void list() {
        if (ms.size() == 0) {
            System.out.println("게시물이 없습니다");
            return;
        }
        System.out.println("==Motivation List==");
        System.out.println("id    /   title   /   body");
        System.out.println("=".repeat(32));

        for (int i = ms.size() - 1; i >= 0; i--) {
            Motivation m = ms.get(i);
            System.out.printf("%d   /   %s  /   %s\n", m.getId(), m.getTitle(), m.getBody());
        }

        
    }

    public void delete(Rq rq) {
        System.out.println("delete 실행");

    }
}
