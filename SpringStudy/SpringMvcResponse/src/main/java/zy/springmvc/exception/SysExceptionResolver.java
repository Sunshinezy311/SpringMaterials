package zy.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof SysException) {
            SysException e = (SysException) ex;
            modelAndView.addObject("errorMsg", e.getMessage());
        } else {
            modelAndView.addObject("errorMsg", "系统内部错误，其他未定义类型的异常！");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
