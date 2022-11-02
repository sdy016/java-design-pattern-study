package com.study.designpatterns.observer.listeners;

import java.io.File;
/**
 * 알림 수신 시 로그에 메시지를 씁니다
 */
public class LogOpenListener implements EventListener {
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("로그를 저장합니다. : " + log + ": 사용자가 " + eventType + " 명령으로 파일 열기를 수행 하였습니다. 파일명 :  " + file.getName());
    }
}
