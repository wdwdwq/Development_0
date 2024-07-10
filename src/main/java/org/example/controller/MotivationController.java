package org.example.controller;

import org.example.entity.Motivation;
import org.example.service.MotivationService;
import org.example.system.Container;
import org.example.system.Rq;

public class MotivationController {
    private MotivationService MS = new MotivationService();

    public MotivationController() {
        MS = new MotivationService();
    }

    public void add() {

        System.out.print("title : ");
        String title = Container.getScanner().nextLine().trim();
        System.out.print("body : ");
        String body = Container.getScanner().nextLine().trim();

        int id = MS.doAdd(title, body);
        System.out.printf("%d번 게시글이 등록 되었습니다\n", id);
    }

    public void list() {
        MS.showList();
    }

    public void delete(Rq rq) {
        System.out.println("delete 실행");
        int id = MS.doDelete(rq);

        if (id == 1) {
            System.out.println("정수 입력 오류");
            return;
        } else if (id == 2) {
            System.out.println("해당 게시물은 없어\n");
            return;
        }
        System.out.printf("%d번 motivation을 삭제했습니다\n", id);
    }


    public void edit(Rq rq) {
        System.out.println("edit 실행");

        int id = MS.doEdit(rq);

        if (id == -1) {
            System.out.println("정수 입력 오류");
            return;
        } else if (id == -2) {
            System.out.printf("해당 motivation은 없어\n");
            return;
        }

        System.out.printf("%d번 motivation을 수정했습니다\n", id);

    }

}


