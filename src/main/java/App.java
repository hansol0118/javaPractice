import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {
    private Scanner sc = new Scanner(System.in);
    private List<WiseSaying> ws = new ArrayList<>();
    private int lastId = 0;

    public void run() {

        System.out.println("== 명령 앱 ==");
        while (true) {
            System.out.print("명령): ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);
            String action = rq.getAction();

            if (action.equals("등록")) {
                actionWrite();

            } else if (action.equals("목록")) {
                actionList();
            } else if (action.startsWith("수정?id=")) {
                actionModify(rq);
            } else if (action.startsWith("삭제?id=")) {
                actionDelete(rq);

            } else if (cmd.equals("종료")) {
                break;
            } else System.out.println("다시 입력해주세요");
        }
    }

    private void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if(id == -1) {
            System.out.println("id를 제대로 입력해주세요.");
            return;
        }

        boolean check = delete(id);

        if (check) {
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        } else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
    }

    private boolean delete(int delTarget) {

        return ws.removeIf((wiseSaying) -> wiseSaying.getId() == delTarget);
    }

    private void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", -1);

        if(id == -1) {
            System.out.println("id를 제대로 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findByID(id);
        if (wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }
        System.out.println("명언(기존): " + wiseSaying.content);
        System.out.print("명언: ");
        String content = sc.nextLine();

        System.out.println("작가(기존): " + wiseSaying.author);
        System.out.print("작가: ");
        String author = sc.nextLine();

        modify(wiseSaying, content, author);
    }

    private void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);
    }

    private WiseSaying findByID(int id) {

        int foundedIndex = findIndexById(id);
        if (foundedIndex == -1) {
            return null;
        }
        return ws.get(foundedIndex);
    }

    private int findIndexById(int id) {
//        for (int i = 0; i < ws.size(); i++) {
//            if (id == ws.get(i).getId()) {
//                return i;
//            }
//        }
//        return -1;

        return IntStream
                .range(0, ws.size())
                .filter((i) -> ws.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayingList = findList();
        for (WiseSaying wiseSaying : wiseSayingList) {
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    private List<WiseSaying> findList() {
        List<WiseSaying> foundedWiseSayingList = new ArrayList<>();

//        for (int i = ws.size() - 1; i >= 0; i--) {
//            WiseSaying foundedWiseSaying = ws.get(i);
//            foundedWiseSayingList.add(foundedWiseSaying);
//        }
        for (WiseSaying wiseSaying : ws.reversed()) {
            foundedWiseSayingList.add(wiseSaying);
        }


        return foundedWiseSayingList;
    }

    private void actionWrite() {
        System.out.print("명언): ");
        String content = sc.nextLine();
        System.out.print("작가): ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    private WiseSaying write(String content, String author) {

        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
        ws.add(wiseSaying);
        return wiseSaying;
    }
}
