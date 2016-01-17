/**
 * 
 */
package com.mysite.fitnesstracker.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Arun J
 *
 */

@Aspect
public class TracingAspect {
	
	Logger logger = Logger.getLogger(TracingAspect.class);
	
	
	@Before("execution(* *(..))")
	public void entering(JoinPoint joinPoint) {
		logger.info("Entering -->> " + joinPoint.getStaticPart().getSignature().toString());
	}
	
	@After("execution(* *(..))")
	public void exiting(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		
		if(args.length > 0) {
			logger.info("Arguments from -->> " + joinPoint.getStaticPart().getSignature().toString() + ":");
			for (Object arg : joinPoint.getArgs()) {
				logger.info(joinPoint.getStaticPart().getSignature().toShortString() + " >> " + arg);
			}
		}
		
		logger.info("Exiting -->> " + joinPoint.getStaticPart().getSignature().toString());
	}

}
