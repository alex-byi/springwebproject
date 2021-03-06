package by.htp.jd2.service;

import by.htp.jd2.entity.Crash;

import java.util.List;

public interface CrashService {

    List<Crash> getAllCrashs(int page);

    int crashCount();

    Crash getCrashById(int id);

    void addCrash(Crash crash);

    List<Crash> getUserCrashes(int userId, int page);

    int userCrashCount(int userId);

}
