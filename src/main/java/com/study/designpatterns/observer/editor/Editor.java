package com.study.designpatterns.observer.editor;

import com.study.designpatterns.observer.publisher.EventManager;

import java.io.File;

/**
 * 다른 객체들로 추적된 구상 게시자
 */
public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        //EventManager 에 행동 부여.
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        //해당하는 EventListerner 에게 noti
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            //해당하는 EventListerner 에게 noti
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }

}
