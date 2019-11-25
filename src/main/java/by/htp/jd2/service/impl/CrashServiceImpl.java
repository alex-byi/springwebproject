package by.htp.jd2.service.impl;

import by.htp.jd2.dao.CrashDao;
import by.htp.jd2.entity.Crash;
import by.htp.jd2.service.CrashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrashServiceImpl implements CrashService {

    private CrashDao crashDao;

    @Autowired
    public void setCrashDao(CrashDao crashDao) {
        this.crashDao = crashDao;
    }

    @Override
    @Transactional
    public List<Crash> getAllCrashs(int page) {
        return crashDao.getAllCrashs(page);
    }

    @Override
    @Transactional
    public int crashCount() {
        return crashDao.crashCount();
    }

    @Override
    @Transactional
    public Crash getCrashById(int id) {
        return crashDao.getCrashById(id);
    }

    @Override
    @Transactional
    public void addCrash(Crash crash) {
        crashDao.addCrash(crash);
    }

    @Override
    @Transactional
    public List<Crash> getUserCrashes(int userId, int page) {
        return crashDao.getUserCrashes(userId, page);
    }

    @Override
    @Transactional
    public int userCrashCount(int userId) {
        return crashDao.userCrashCount(userId);
    }
}
