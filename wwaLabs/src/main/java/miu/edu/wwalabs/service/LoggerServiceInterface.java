package miu.edu.wwalabs.service;

import miu.edu.wwalabs.model.Logger;
import org.springframework.stereotype.Service;

@Service

public interface LoggerServiceInterface {
    public void saveLogger(Logger logger);
}
