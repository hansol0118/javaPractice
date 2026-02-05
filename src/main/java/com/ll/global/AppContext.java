package com.ll.global;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;
import com.ll.wiseSaying.repository.WiseSayingRepository;
import com.ll.wiseSaying.service.WiseSayingService;

public class AppContext {
    public static WiseSayingController wiseSayingController = new WiseSayingController();
    public static WiseSayingService wiseSayingService = new WiseSayingService();
    public static WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public static SystemController systemController = new SystemController();
}
