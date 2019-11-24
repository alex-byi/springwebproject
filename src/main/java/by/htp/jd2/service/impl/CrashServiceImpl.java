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
    public Crash getCrashById(int id) {
        return crashDao.getCrashById(id);
    }

    @Override
    public void addCrash(Crash crash) {
        crashDao.addCrash(crash);
    }
}
