package com.ll;

import com.ll.global.AppContext;
import com.ll.global.Rq;
import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private Scanner sc = new Scanner(System.in);
    private SystemController systemController = AppContext.systemController;
    private WiseSayingController wiseSayingController = AppContext.wiseSayingController;
    public void run() {

        System.out.println("== 명령 앱 ==");
        while (true) {
            System.out.print("명령): ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);
            String action = rq.getAction();

            if (action.equals("등록")) {
                wiseSayingController.actionWrite();

            } else if (action.equals("목록")) {
                wiseSayingController.actionList();
            } else if (action.equals("수정")) {
                wiseSayingController.actionModify(rq);
            } else if (action.equals("삭제")) {
                wiseSayingController.actionDelete(rq);

            } else if (cmd.equals("종료")) {
                systemController.exit();
                break;
            } else System.out.println("다시 입력해주세요");
        }
    }

}
