package com.study.designpatterns.observer.publisher;

import com.study.designpatterns.observer.listeners.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 기초 게시자  (발행자)
 */
public class EventManager {
    //Operation(String)들을 담는 전역 변수.
    Map<String, List<EventListener>> listeners = new HashMap<>();

    //Operation 들을 받아서 listeners 변수에 put
    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    //구독
    public void subscribe(String eventType, EventListener listener) {
        //구독 요청 시 listeners 변수내 해당하는 eventType을 가지고 있는 항목을 찾아
        //List<EventListener> 내 listener 추가 처리.
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    //구독 취소
    public void unsubscribe(String eventType, EventListener listener) {
        //구독 취소 요청 시 listeners 변수내 해당하는 eventType을 가지고 있는 항목을 찾아
        //List<EventListener> 내 listener 제거 처리.
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    //noti
    public void notify(String eventType, File file) {
        //listeners 변수내 해당하는 eventType을 가지고 있는 항목을 찾아
        //해당 항목에 등록된 listener에게 update 처리.
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
