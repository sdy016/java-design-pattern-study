package com.study.designpatterns.observer.listeners;

import java.io.File;

/**
 * 알림 수신 시 이메일 전송
 */
public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("누군가 "+ eventType +" 명령을 내렸습니다. [" + email + "] 이메일 계정으로 메일이 발송 되었습니다.  파일명은 : " + file.getName());
    }
}
