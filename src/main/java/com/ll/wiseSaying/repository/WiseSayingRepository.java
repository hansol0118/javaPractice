package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingRepository {
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

    public List<WiseSaying> findList() {
        List<WiseSaying> foundedWiseSayingList = new ArrayList<>();

        for (WiseSaying wiseSaying : ws.reversed()) {
            foundedWiseSayingList.add(wiseSaying);
        }
        return foundedWiseSayingList;
    }

    public  boolean delete(int id) {

        return ws.removeIf((wiseSaying) -> wiseSaying.getId() == id);
    }

    public WiseSaying save (String content, String author){
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        ws.add(wiseSaying);

        return wiseSaying;
    }
}
