package study.caching.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PerformanceMeasurement {

    @Pointcut("execution(* study.caching.service.SchoolService.getSchool(..))")
    public void getSchoolList(){}

    @Around("getSchoolList()")
    public Object calculatePerformance(ProceedingJoinPoint proceedingJoinPoint) {

        Object result = null;
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            result = proceedingJoinPoint.proceed();
            stopWatch.stop();
            System.out.println("성능측정대상 " + proceedingJoinPoint.getSignature());
            System.out.println(stopWatch.prettyPrint());
        } catch (Throwable e) {
            System.out.println("exception 발생!! " + e.getMessage());
        }
        return result;
    }
}
