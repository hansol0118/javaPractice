package com.ll.wiseSaying.service;

import com.ll.global.AppContext;
import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.repository.WiseSayingRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private List<WiseSaying> ws = new ArrayList<>();
    WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;
    private int lastId = 0;


//    public  List<WiseSaying> findList() {
//        List<WiseSaying> foundedWiseSayingList = new ArrayList<>();
//

    /// /        for (int i = ws.size() - 1; i >= 0; i--) {
    /// /            com.ll.wiseSaying.WiseSaying foundedWiseSaying = ws.get(i);
    /// /            foundedWiseSayingList.add(foundedWiseSaying);
    /// /        }
//        for (WiseSaying wiseSaying : ws.reversed()) {
//            foundedWiseSayingList.add(wiseSaying);
//        }
//        return foundedWiseSayingList;
//    }
    public List<WiseSaying> findList() {
        return wiseSayingRepository.findList();
    }

    public int findIndexById(int id) {
        return wiseSayingRepository.findIndexById(id);
    }
    public WiseSaying findById(int id) {
        return wiseSayingRepository.findByID(id);
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
        wiseSaying.setCreateDate(LocalDateTime.now());
        wiseSaying.setModifyDate(LocalDateTime.now());
        return wiseSayingRepository.save(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);

        wiseSayingRepository.save(wiseSaying);
    }

    public boolean delete(int delTarget) {
        return wiseSayingRepository.delete(delTarget);
    }
}
