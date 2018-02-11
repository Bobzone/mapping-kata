package com.bobzone.training.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@Component
@Aspect
class DbStatsAspect {
    private static final Logger logger = Logger.getLogger(DbStatsAspect.class.getName());

    @PersistenceContext
    private EntityManager em;

    @Around(value = "execution(* com.bobzone.training.service.*.*(..))")
    public Object getStats(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final Statistics statistics = em.unwrap(Session.class).getSessionFactory().getStatistics();
        statistics.setStatisticsEnabled(true);

        final long start = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        final long end = System.currentTimeMillis();

        if (end - start > 3000) {
            logger.warning("Queries take too much time.");
        }

        return proceed;
    }
}
