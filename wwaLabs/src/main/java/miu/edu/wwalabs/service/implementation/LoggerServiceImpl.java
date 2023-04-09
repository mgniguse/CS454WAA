package miu.edu.wwalabs.service.implementation;

import miu.edu.wwalabs.model.Logger;
import miu.edu.wwalabs.repository.LoggerRepository;
import miu.edu.wwalabs.service.LoggerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class LoggerServiceImpl implements LoggerServiceInterface {
    @Autowired
    LoggerRepository loggerRepository;
    @Override
    public void saveLogger(Logger logger) {
        loggerRepository.save(logger);
    }
}
