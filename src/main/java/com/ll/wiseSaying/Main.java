package com.ll.wiseSaying;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.run();
    }
}

//import java.util.Scanner;
//
//public class com.ll.wiseSaying.Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        wise [] ws = new wise[100];
//        int wise_num = 0;
//
//        System.out.println("== 명령 앱 ==");
//        while (true) {
//            System.out.print("명령): ");
//            String cmd = sc.nextLine();
//
//            if (cmd.equals("등록")) {
//                System.out.print("명언): ");
//                String wisesaying = sc.nextLine();
//                System.out.print("작가): ");
//                String author = sc.nextLine();
//                ws[wise_num] = new wise(wise_num++,wisesaying,author);
//                System.out.println(wise_num + "번 명언이 등록되었습니다.");
//            } else if (cmd.equals("목록")) {
//                System.out.println("번호 / 작가 / 명언");
//                System.out.println("----------------------");
//                for(int i=0;i<wise_num;i++){
//                    System.out.println(ws[i].id + " / " + ws[i].content +" / " + ws[i].author);
//                }
//            } else if (cmd.startsWith("삭제?id=")) {
//                int Del_wise = (int)(cmd.charAt(cmd.length()-1) - '0');
//                for (int i = 0 ; i<wise_num ; i++){
//                    if (ws[i].id == Del_wise){
//                        for(int j =Del_wise; j <= wise_num; j++){
//                            ws[i-1] = ws[i];
//                        }
//                        wise_num--;
//                        break;
//                    }
//                    else System.out.println("1번 명언은 존재하지 않습니다.");
//                }
//
//            } else if (cmd.equals("종료")) {
//                break;
//            }
//
//            else System.out.println("다시 입력해주세요");
//        }
//    }
//}
