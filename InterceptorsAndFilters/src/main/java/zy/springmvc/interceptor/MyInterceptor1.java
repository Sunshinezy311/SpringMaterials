package zy.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    //拦截器预处理，在Controller方法执行前执行

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.如果返回true则放行，执行下一个拦截器或Controller方法
        System.out.println("预处理：MyInterceptor1类的preHandle方法执行了");
        return true;
        // 2.如果返回false，则不放行，可以用request和response跳转到某一个页面，不会执行Controller方法
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
//        return false;
    }

    //后处理方法，再controller方法执行后，success.jsp执行前执行的方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理：MyInterceptor1类的postHandle方法执行了");
        //后处理方法中也可以执行页面跳转等功能
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }

    //最终执行方法，在success.jsp方法执行后，注意这里不能做页面跳转等操作了。
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("最终处理：MyInterceptor1类的afterCompletion方法执行了");
    }
}
