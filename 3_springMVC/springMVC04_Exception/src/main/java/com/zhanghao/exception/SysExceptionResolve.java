package com.zhanghao.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolve implements HandlerExceptionResolver {

    /**
     * 处理异常
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException se = null;
        if (e instanceof SysException){
            se = (SysException) e;
        }else {
            //其他异常，全部解释为服务器正忙
            se = new SysException("服务器正忙。。。");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg",se.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
