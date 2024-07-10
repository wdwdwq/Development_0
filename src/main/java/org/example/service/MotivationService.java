package org.example.service;

import org.example.entity.Motivation;
import org.example.system.Container;
import org.example.system.Rq;

import java.util.ArrayList;
import java.util.List;

public class MotivationService {
    int lastId;
    List<Motivation> ms;

    public MotivationService() {
        lastId = 0;
        ms = new ArrayList<>();

    }

    private Motivation findById(int id) {
        for (Motivation motivation : ms) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }

    public int doAdd(String title, String body) {
        int id = lastId + 1;
        Motivation motivation = new Motivation(id, title, body);
        ms.add(motivation);

        lastId = id;

        return id;
    }

    public void showList() {
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

    public int doDelete(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParams("id"));
        } catch (NumberFormatException e) {
            System.out.println("정수 입력 오류");
            return -1;
        }

        Motivation motivation = findById(id);

        if (motivation == null) {
            return -2;
        }

        ms.remove(motivation);
        return id;
    }

    public int doEdit(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParams("id"));
        } catch (NumberFormatException e) {
            return -1;
        }

        Motivation m = findById(id);

        if (m == null) {
            return -2;
        }

        System.out.println("body(기존) : " + m.getTitle());
        System.out.println("source(기존) : " + m.getBody());

        System.out.print("body : ");
        String title = Container.getScanner().nextLine();
        System.out.print("source : ");
        String body = Container.getScanner().nextLine();

        // 불러온 motivation의 인스턴스변수 수정
        m.setTitle(title);
        m.setBody(body);

        return id;
    }
}
