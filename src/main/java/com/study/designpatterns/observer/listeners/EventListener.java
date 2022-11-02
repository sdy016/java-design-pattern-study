package com.study.designpatterns.observer.listeners;

import java.io.File;

/**
 * 공통 옵서버 인터페이스
 */
public interface EventListener {
    void update(String eventType, File file);
}