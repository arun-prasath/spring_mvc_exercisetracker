/**
 * 
 */
package com.mysite.fitnesstracker.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * @author Arun J
 *
 */

@Aspect
public class TracingAspect {
	
	Logger logger = Logger.getLogger(TracingAspect.class);
	
	@Around("execution(* (@org.springframework.stereotype.Controller *).*(..))")
	public Object catchException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		logger.info("Entering -->> " + proceedingJoinPoint.getStaticPart().getSignature().toString());
		
		Object[] args = proceedingJoinPoint.getArgs();
		
		if(args.length > 0) {
			logger.info("Arguments from -->> " + proceedingJoinPoint.getStaticPart().getSignature().toString() + ":");
			for (Object arg : proceedingJoinPoint.getArgs()) {
				logger.info(proceedingJoinPoint.getStaticPart().getSignature().toShortString() + " >> " + arg);
			}
		}
		
		try {
			return proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.error("An exception occurred in " + proceedingJoinPoint.getStaticPart().getSignature().toString());
			logger.error("Exception message is: " + e.getMessage());
			throw e;
		} finally {
			logger.info("Exiting -->> " + proceedingJoinPoint.getStaticPart().getSignature().toString());
		}
	}
	
}
