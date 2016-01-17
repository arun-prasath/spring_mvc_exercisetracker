/**
 * 
 */
package com.mysite.fitnesstracker.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author Arun J
 *
 */

@Aspect
public class TracingAspect {
	
	Logger logger = Logger.getLogger(TracingAspect.class);
	
	
	@Around("execution(* (@org.springframework.stereotype.Controller *).*(..))")
	public Object catchException(ProceedingJoinPoint proceedingJoinPoint) {
		logger.info("Entering -->> " + proceedingJoinPoint.getStaticPart().getSignature().toString());
		try {
			return proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.error("An exception occurred in " + proceedingJoinPoint.getStaticPart().getSignature().toString());
			logger.error("Exception message is: " + e.getMessage());
		} finally {
			Object[] args = proceedingJoinPoint.getArgs();
			
			if(args.length > 0) {
				logger.info("Arguments from -->> " + proceedingJoinPoint.getStaticPart().getSignature().toString() + ":");
				for (Object arg : proceedingJoinPoint.getArgs()) {
					logger.info(proceedingJoinPoint.getStaticPart().getSignature().toShortString() + " >> " + arg);
				}
			}
			
			logger.info("Exiting -->> " + proceedingJoinPoint.getStaticPart().getSignature().toString());
		}
		return null;
	}

}
