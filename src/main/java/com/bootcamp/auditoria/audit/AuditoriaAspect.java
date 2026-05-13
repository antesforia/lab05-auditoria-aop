package com.bootcamp.auditoria.audit;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AuditoriaAspect {

    @Around("execution(* com.bootcamp.auditoria..*(..))")
    public Object auditarMetodo(
            ProceedingJoinPoint joinPoint
    ) throws Throwable {

        String metodo = joinPoint
                .getSignature()
                .toShortString();

        log.info("AUDITORIA -> Iniciando método: {}", metodo);

        long inicio = System.currentTimeMillis();

        Object resultado = joinPoint.proceed();

        long fin = System.currentTimeMillis();

        log.info(
                "AUDITORIA -> Método finalizado: {} en {} ms",
                metodo,
                (fin - inicio)
        );

        return resultado;
    }

    @AfterThrowing(
            pointcut = "execution(* com.bootcamp.auditoria..*(..))",
            throwing = "exception"
    )
    public void auditarExcepcion(Exception exception) {

        log.error(
                "AUDITORIA -> Excepción detectada: {}",
                exception.getMessage()
        );
    }
}