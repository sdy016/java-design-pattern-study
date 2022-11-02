package com.study.designpatterns.observer;

import com.study.designpatterns.MainInterface;
import com.study.designpatterns.observer.editor.Editor;
import com.study.designpatterns.observer.listeners.EmailNotificationListener;
import com.study.designpatterns.observer.listeners.LogOpenListener;
import com.study.designpatterns.observer.listeners.OpenAuthListener;

public class ObserverPatternExcute  implements MainInterface {
    @Override
    public void mainExecute() {
        Editor editor = new Editor();
        //open operation 에대한 구독 신청.
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        //open operation 에대한 구독 신청.
        editor.events.subscribe("open", new OpenAuthListener("ADMIN"));
        //open operation 에대한 구독 신청.
        editor.events.subscribe("open", new OpenAuthListener("USER"));
        //save operation 에대한 구독 신청.
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
