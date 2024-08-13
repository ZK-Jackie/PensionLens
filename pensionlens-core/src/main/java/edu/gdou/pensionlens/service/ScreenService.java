package edu.gdou.pensionlens.service;

import edu.gdou.pensionlens.pojo.Screen;

import java.util.List;

public interface ScreenService {

    Screen getScreenInfo(Integer screenId);

    void updateScreenInfo(Screen calcScreen);
}
