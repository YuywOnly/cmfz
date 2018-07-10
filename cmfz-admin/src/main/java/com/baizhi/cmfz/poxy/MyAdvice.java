package com.baizhi.cmfz.poxy;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 22:20
 **/

@Aspect
public class MyAdvice {

    @Autowired
    private LogService logService;


    @Pointcut("execution(* com.baizhi.cmfz.serviceImpl.*ServiceImpl.modify*(..)) || execution(* com.baizhi.cmfz.serviceImpl.*ServiceImpl.remove*(..)) || execution(* com.baizhi.cmfz.serviceImpl.*ServiceImpl.add*(..)) ")
    public void pc() {
    }


    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        Log log = new Log();

        //获取登录的管理员名
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session =request.getSession();
        String managerName = "";
        managerName = (String)session.getAttribute("managerName");
        log.setLogUser(managerName);



        //获取数据源类型(操作的为哪一个service)
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();

        String s = String.valueOf(declaringClass);//转化成字符串
        String substring = s.substring(s.lastIndexOf('.')+1); //截取最后的类名
        String replace = substring.replace("Service", "");//得到要操作的数据源

        log.setLogResource(replace);


        //获取操作方法名
        String methodName = method+"";
        if(methodName.contains("add")){
            log.setLogAction("新增");
        }else if(methodName.contains("remove")){
            log.setLogAction("删除");
        }else {
            log.setLogAction("修改");
        }



//        执行方法
        Object obj = pjp.proceed();


//        获取参数 message
        String message = "";
        Object[] args = pjp.getArgs();
        for (Object arg:args ) {
            message += arg;
        }
        log.setLogMessage(message);

        try {
            if((obj+"").equals("true")){
                log.setLogResult("successful");
            }else {
                log.setLogResult("fail");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.setLogResult("fail");
        }

        logService.addLog(log);



        return obj;
    }

}