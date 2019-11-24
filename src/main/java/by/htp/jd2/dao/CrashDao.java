package by.htp.jd2.dao;

import by.htp.jd2.entity.Crash;

import java.util.List;

public interface CrashDao {
    List<Crash> getAllCrashs (int page);
    int crashCount();
}
