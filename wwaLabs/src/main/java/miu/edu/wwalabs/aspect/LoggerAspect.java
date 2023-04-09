package miu.edu.wwalabs.aspect;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import miu.edu.wwalabs.model.Logger;
import miu.edu.wwalabs.repository.LoggerRepository;
import miu.edu.wwalabs.service.LoggerServiceInterface;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    //LoggerServiceInterface loggerService;
    LoggerRepository loggerRepository;
    java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(* miu.edu.wwalabs.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        Object result=null;
        long beginTime= System.currentTimeMillis();
        try{
            result= joinPoint.proceed();
        }catch(Throwable e){
            e.printStackTrace();
        }
        try{
            saveLog(joinPoint, beginTime);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return result;
    }
    private void saveLog(ProceedingJoinPoint joinPoint, long time)throws Throwable{
        Logger log = new Logger();
        long start = System.nanoTime();
        joinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(joinPoint.getSignature().getName()+" takes ns: "+ (finish-start));
        log.setTime(finish-start);
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.setDate(java.time.Instant.ofEpochMilli(time).atZone(java.time.ZoneId.of("America/New_York")).toLocalDate());
        log.setOperation(request.getMethod());
        log.setPrinciple("Test Principle");
        log.setOperation("Test Operation");
        //loggerService.saveLogger(log);
        loggerRepository.save(log);
    }

}
