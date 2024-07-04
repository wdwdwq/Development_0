package org.example;

import java.util.Scanner;

public class App {
    //public <- 다른 클래스에서도 사용할 수 있다
    //protected <- 같은 패키지 안에서 접근 o, 상속받은 클래스에서만 접근 가능
    //private 해당클래스에서만 사용가능
    private Scanner sc;

    public App(Scanner sc) { //public 모든 클래에서 쓰는 
        this.sc = sc;
    }

//    == Board add ==
//    command) add
//    title : 1
//    body : 1
//    1번 게시판이 등록되었습니다
//    == motivation list ==
//    id   //   motivation   //  source
//     2   //     456        //    asd
//     1   //     123        //    qwe

    public void run() {
        System.out.println("==Board Start==");

        int lastId = 1;
        while (true) {
            System.out.print("command )");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("==Board End==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어 입력해");
                continue;
            }

            if (cmd.equals("add")) {
                System.out.print("title : ");
                String title = sc.nextLine().trim();
                System.out.print("body : ");
                String body = sc.nextLine().trim();


                System.out.printf("%s번 게시판이 등록되었습니다\n", lastId);
                lastId++;
            }else if(cmd.equals("list")) {
                System.out.println("==Board List==");
                System.out.printf(" id  //  title   //  body    \n");
                System.out.println("=".repeat(35));
            }

        }


    }

}
