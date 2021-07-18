package com.springpractical.bharat.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Bharat Padhiyar
 * Aspect Configuration class.
 * It will log the Request processing time with some request data.
 */
@Aspect
@Component
public class AspectConfiguration {

    private final Log log = LogFactory.getLog(AspectConfiguration.class);

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(public * *(..))")
    public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object response;
        try {
            response = proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();

            //TODO: We can grab the IP address from the HTTP Header X-Forwarded-FOR if the application is running with the load balancer.
            log.info("\nRequest Data : " + "\n\tIP address of Client : " + request.getRemoteAddr() +
                    "\n\tRequest URI with method : " + request.getMethod() + " : " + request.getRequestURI() +
                    "\n Total time taken for execution : " + stopWatch.getLastTaskTimeMillis() + " ms");
        }

        return response;
    }
}
