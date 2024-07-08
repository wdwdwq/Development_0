package org.example;

import org.example.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    //public <- 다른 클래스에서도 사용할 수 있다
    //protected <- 같은 패키지 안에서 접근 o, 상속받은 클래스에서만 접근 가능
    //private 해당클래스에서만 사용가능
    private Scanner sc; // App 안에서만 사용 가능

    public App(Scanner sc) { //public 모든 클래에서 쓰는 
        this.sc = sc;
    }


    public void run() {
        System.out.println("==Motivation Start==");

        int lastId = 0;

        List<Motivation> ms = new ArrayList<>();
        while (true) { // 무한 루프
            System.out.print("command )");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("exit")) {
                System.out.println("==Board End==");
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어 입력해");
                continue;
            }
            if (cmd.equals("add")) {
                int id = lastId + 1; // id 생성 후 lastId 값 증가
                System.out.print("title : "); // 
                String title = sc.nextLine().trim();
                System.out.print("body : ");
                String body = sc.nextLine().trim();

                Motivation m = new Motivation(id, title, body);
                ms.add(m);

                System.out.printf("%s번 게시판이 등록되었습니다\n", id);
                lastId++;
            } else if (cmd.equals("list")) {

                if(ms.isEmpty()) {
                    System.out.println("등록된 글 없음");
                    continue;
                }
                System.out.println("== motivation list ==");
                System.out.print("      id      //      title       \n");
                System.out.println("=".repeat(32));

                for (int i = ms.size() - 1; i >= 0; i--) {
                    Motivation m = ms.get(i);
                    System.out.printf("      %d      //      %s       \n",m.getId(),m.getTitle());
                }

                if(ms.isEmpty()) {
                    System.out.println("등록된 게시판이 없습니다 ");
                }
            }

        }


    }

}
