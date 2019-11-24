package by.htp.jd2.dao;

import by.htp.jd2.entity.Crash;
import by.htp.jd2.entity.Order;

import java.util.List;

public interface CrashDao {

    List<Crash> getAllCrashs(int page);

    int crashCount();

    Crash getCrashById(int id);

    void addCrash (Crash crash);
}
