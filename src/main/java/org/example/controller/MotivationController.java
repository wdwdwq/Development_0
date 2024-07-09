package org.example.controller;

import org.example.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {
    int lastId;
    List<Motivation> ms;
    Scanner sc;

    public MotivationController(Scanner sc) {
        this.sc = sc;
        this.lastId = 0;
        ms = new ArrayList<>();
    }
    public void add() {
        int id = lastId + 1; // id 생성 후 lastId 값 증가
        System.out.print("title : "); //
        String title = sc.nextLine().trim();
        System.out.print("body : ");
        String body = sc.nextLine().trim();

        Motivation m = new Motivation(id, title, body);
        ms.add(m);

        System.out.printf("%s번 게시판이 등록되었습니다\n", id);
        lastId++;
    }

    public void list() {

        if(ms.isEmpty()) {
            System.out.println("등록된 글 없음");
            return;
        }
        System.out.println("== motivation list ==");
        System.out.print("      id      //      title       \n");
        System.out.println("=".repeat(32));

        for (int i = ms.size() - 1; i >= 0; i--) {
            Motivation m = ms.get(i);

            if (m.getBody().length() > 7) { // 본문 내용이 7지 이상이면
                System.out.printf("   %d  //    %s    //    %s  \n", m.getId(), m.getBody().substring(0, 5) + "...", m.getTitle());//본문 내용을 처음 5자까지만 출력하고 "..." 붙인다 7자 미만이면
                continue;
            }

            System.out.printf("      %d      //      %s       \n",m.getId(),m.getTitle());
        } // 제목 내용을 그대로 출력

        if(ms.isEmpty()) {
            System.out.println("등록된 게시판이 없습니다 ");
        }
    }
}
