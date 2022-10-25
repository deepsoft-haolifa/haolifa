//package com.deepsoft.haolifa.aspect;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.deepsoft.haolifa.annotation.LogNotPrint;
//import com.deepsoft.haolifa.model.dto.AspectLogDTO;
//import com.deepsoft.haolifa.model.dto.BaseException;
//import com.google.gson.JsonObject;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.ThrowsAdvice;
//import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.*;
//import org.springframework.web.servlet.HandlerMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.*;
//import java.util.stream.Stream;
//
///**
// * log 日志打印
// */
//
//@Aspect
//@Component
//@Slf4j
//public class LogAspect implements ThrowsAdvice {
//
//    @Pointcut("execution(* com.deepsoft.haolifa.controller..*.*(..))")
//    public void webLog() {
//    }
//
//    @AfterThrowing(pointcut = "webLog()", throwing = "ex")
//    public void ExceptionHandlingAdvice(JoinPoint jp, Exception ex) {
//        if (!(ex instanceof BaseException)) {
//            Logger logger = LoggerFactory.getLogger(jp.getTarget().getClass());
//            logger.error("{} fail:", jp.getSignature().getName(), ex);
//        }
//    }
//
//    @Before("webLog()")
//    public void before(JoinPoint joinPoint) {
//        // 判断类上的注解
//        if (!joinPoint.getTarget().getClass().isAnnotationPresent(LogNotPrint.class)) {
//            //获取必要的参数
//            String methodType = joinPoint.getSignature().getName();
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            String requestURI = request.getRequestURI();
//            String method = request.getMethod();
//            String header = "";
//            String contentType = request.getContentType();
//            // 获取body
//            String body = "";
//            if (null != contentType && contentType.equalsIgnoreCase("application/json")) {
//                body = requestBody(request);
//            }
//            log.info("【Request】 uri={}|method={}|header={}|contentType={}|params={}|body={}", requestURI, method, header, contentType, requestParam(request), body);
//        }
//    }
//
////    @AfterReturning(value = "webLog()", returning = "rvt")
////    public void after(JoinPoint joinPoint, Object rvt) {
//////        log.info("【Response】 {}/{}|{} ", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), JSONObject.toJSONString(rvt,SerializerFeature.PrettyFormat));
////    }
//
//    /**
//     * 获取请求参数
//     *
//     * @param request
//     * @return
//     */
//    private Map<String, Object> requestParam(HttpServletRequest request) {
//        Enumeration<String> enu = request.getParameterNames();
//        Map<String, Object> map = new HashMap<>();
//        while (enu.hasMoreElements()) {
//            String paraName = enu.nextElement();
//            String value = request.getParameter(paraName);
//            map.put(paraName, value);
//        }
//        return map;
//    }
//
//    /**
//     * 获取请求body
//     *
//     * @param request
//     * @return
//     */
//    private String requestBody(HttpServletRequest request) {
//        final StringBuilder body = new StringBuilder();
//        if (request instanceof HttpServletRequestWrapper) {
//            Stream<String> lines = null;
//            try {
//                lines = request.getReader().lines();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            lines.forEachOrdered(s -> body.append(s.trim()));
//        }
//        return body.toString();
//    }
//
//
//
////    @Around("webLog()")
////    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
////        Object result = null;
////        //执行方法
////        result = joinPoint.proceed();
////        // 判断类上的注解
////        if (!joinPoint.getTarget().getClass().isAnnotationPresent(LogNotPrint.class)) {
////            //获取必要的参数
////            String methodType = joinPoint.getSignature().getName();
////            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
////            String requestBody = charReader(request);
////            Map requestMap = getRequestMap(request, requestBody);
////            Date start = new Date();
////            //写api调用日志
////        }
////        return result;
////    }
//
////
////    /**
////     * 获取请求信息
////     *
////     * @param request
////     * @param requestBody
////     * @return
////     */
////    public Map getRequestMap(HttpServletRequest request, Object requestBody) {
////
////        LinkedHashMap<String, Object> requestMap = new LinkedHashMap<>();
////        //将请求URI置入
////        String requestURI = request.getRequestURI();
////        requestMap.put("uri", requestURI);
////        //将请求头置入
//////        HashMap<Object, Object> requestHeader = new HashMap<>();
//////        Enumeration<String> headerNames = request.getHeaderNames();
//////        while (headerNames.hasMoreElements()) {
//////            String headerName = headerNames.nextElement();
//////            String headerValue = request.getHeader(headerName);
//////            requestHeader.put(headerName, headerValue);
//////        }
//////        requestMap.put("requestHeader", requestHeader);
////
////        //将请求地址变量置入
////        HashMap<Object, Object> pathVariable = new HashMap<>();
////        NativeWebRequest webRequest = new ServletWebRequest(request);
////        Map<String, String> uriTemplateVars = (Map<String, String>) webRequest
////                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
////        pathVariable.putAll(uriTemplateVars);
////        requestMap.put("pathVariable", pathVariable);
////
////        //将请求参数置入
////        Map<String, String[]> parameterMap = request.getParameterMap();
////        HashMap<Object, Object> requestParam = new HashMap<>();
////        if (parameterMap != null && parameterMap.size() > 0) {
////            Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
////            while (iterator.hasNext()) {
////                Map.Entry<String, String[]> next = iterator.next();
////                String s = next.getValue()[0];
////                int length = s.length();
////                if (length > 100) {
////                    s = s.substring(0, 40) + "*****" + s.substring(length - 40);
////                }
////                requestParam.put(next.getKey(), s);
////            }
////        }
////        requestMap.put("requestParam", requestParam);
////
////        //将请求体置入
////        String body = (String) requestBody;
////        if (body.length() > 1500) {
////            try {
////                Map<String, Object> map = JSONObject.parseObject((String) requestBody, Map.class);
////                HashMap<String, Object> newMap = new HashMap<>();
////                Set<Map.Entry<String, Object>> entries = map.entrySet();
////                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
////                while (iterator.hasNext()) {
////                    try {
////                        Map.Entry<String, Object> next = iterator.next();
////                        String key = next.getKey();
////                        Object value = next.getValue();
////                        if (value instanceof String && ((String) value).length() > 100) {
////                            value = ((String) value).substring(0, 40) + "*****" + ((String) value).substring(((String) value).length() - 40);
////                        }
////                        newMap.put(key, value);
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                    }
////                }
////                requestMap.put("requestBody", newMap);
////            } catch (Exception e) {
////                e.printStackTrace();
////                requestMap.put("requestBody", JSONObject.toJSONString((String) requestBody));
////            }
////
////        } else {
////            requestMap.put("requestBody", JSONObject.toJSONString((String) requestBody));
////        }
////
////        return requestMap;
////    }
////
////
////    /**
////     * 读取JsonBody
////     *
////     * @param request
////     * @return
////     */
////    String charReader(HttpServletRequest request) {
////        try {
////            BufferedReader br = request.getReader();
////            String str, wholeStr = "";
////            while ((str = br.readLine()) != null) {
////                wholeStr += str;
////            }
////            return wholeStr;
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return "";
////    }
////
////    private void getMethodAnnotion(ProceedingJoinPoint joinPoint) {
////        // 判断方法上的注解
////        Class<?>[] parameterTypes = new Class[joinPoint.getArgs().length];
////        for (int i = 0; i < joinPoint.getArgs().length; i++) {
////            parameterTypes[i] = joinPoint.getArgs()[i].getClass();
////        }
////        try {
////            if (!joinPoint.getTarget().getClass().getDeclaredMethod(joinPoint.getSignature().getName(), parameterTypes).isAnnotationPresent(LogNotPrint.class)) {
////
////            }
////        } catch (NoSuchMethodException e) {
////            e.printStackTrace();
////        }
////    }
//
//}
