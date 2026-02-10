package com.back.wiseSaying.repository;

import com.back.wiseSaying.entity.WiseSaying;

public class WiseSayingFileRepository {

    public WiseSaying save(WiseSaying wiseSaying) {
        return wiseSaying;
    }

    public WiseSaying findByIdOrNull(int id) {
        return null;
    }
}
