package com.ll.wiseSaying.service;

import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingService {
    private List<WiseSaying> ws = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying findByID(int id) {

        int foundedIndex = findIndexById(id);
        if (foundedIndex == -1) {
            return null;
        }
        return ws.get(foundedIndex);
    }

    public int findIndexById(int id) {

        return IntStream
                .range(0, ws.size())
                .filter((i) -> ws.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }

    public  List<WiseSaying> findList() {
        List<WiseSaying> foundedWiseSayingList = new ArrayList<>();

//        for (int i = ws.size() - 1; i >= 0; i--) {
//            com.ll.wiseSaying.WiseSaying foundedWiseSaying = ws.get(i);
//            foundedWiseSayingList.add(foundedWiseSaying);
//        }
        for (WiseSaying wiseSaying : ws.reversed()) {
            foundedWiseSayingList.add(wiseSaying);
        }
        return foundedWiseSayingList;
    }

    public  WiseSaying write(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        ws.add(wiseSaying);

        return wiseSaying;
    }

    public  void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);
    }

    public  boolean delete(int delTarget) {

        return ws.removeIf((wiseSaying) -> wiseSaying.getId() == delTarget);
    }
}
