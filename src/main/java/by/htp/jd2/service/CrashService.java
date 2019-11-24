package by.htp.jd2.service;

import by.htp.jd2.entity.Crash;

import java.util.List;

public interface CrashService {

    List<Crash> getAllCrashs(int page);

    int crashCount();

}
