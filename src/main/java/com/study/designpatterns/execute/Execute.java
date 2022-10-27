package com.study.designpatterns.execute;

import com.study.designpatterns.MainInterface;

public class Execute{
    private MainInterface mainInterface;

    public Execute(MainInterface _mainInterface) {
        mainInterface = _mainInterface;
    }

    public void mainExecute() {
        mainInterface.mainExecute();
    }
}
