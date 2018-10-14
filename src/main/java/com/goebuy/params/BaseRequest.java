package com.goebuy.params;

import com.google.common.base.Strings;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

/**
 * Created by luodejin on 2018/9/28.
 */
public class BaseRequest {
    private HttpServletRequest request;
    private Map<String, String> pathVariables;

    public BaseRequest(HttpServletRequest request) {
        init(request);
    }

    private void init(HttpServletRequest request) {
        this.request = request;
        this.pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if (this.pathVariables == null) {
            this.pathVariables = Collections.emptyMap();
        }
    }

    public String getValWithDefault(String key, String defaultVal) {
        String res = defaultVal;
        //优先获取path里的,其次query参数
        if (pathVariables.containsKey(key)) {
            res = Strings.nullToEmpty(pathVariables.get(key));
        } else if (!Strings.isNullOrEmpty(request.getParameter(key))) {
            res = request.getParameter(key);
        }
        return res;
    }
}
