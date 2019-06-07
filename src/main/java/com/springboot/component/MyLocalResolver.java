package com.springboot.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by zhang_htao on 2019/6/7.
 */

public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        System.out.println(l);
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            List<String> collect = Arrays.stream(l.split("_")).collect(Collectors.toList());
            locale = new Locale(collect.get(0),collect.get(1));
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
