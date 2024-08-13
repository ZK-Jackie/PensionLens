package edu.gdou.pensionlens.service;

import edu.gdou.pensionlens.pojo.Detail;

import java.util.List;

public interface DetailService {

    List<Detail> getScreenDetails(Integer screenId);
}
