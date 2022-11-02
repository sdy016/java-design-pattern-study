package com.study.designpatterns.observer.listeners;

import java.io.File;

public class OpenAuthListener  implements EventListener {
    private String auth;

    public OpenAuthListener(String userAuth) {
        this.auth = userAuth;
    }

    @Override
    public void update(String eventType, File file) {
        if(this.auth.equals("ADMIN")) {
            System.out.println(auth + " 권한을 가진 사용자가 " + eventType + " 명령으로 파일 열기를 수행 하였습니다. 파일명 :  " + file.getName());
        }
        else {
            System.out.println(auth + " 권한을 가진 사용자가 " + eventType + " 명령으로 파일 열기를 수행 하려고 하였지만 제가 무사히 막았습니다. 파일명 :  " + file.getName());
        }
    }
}
