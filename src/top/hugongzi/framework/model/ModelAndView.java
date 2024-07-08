package top.hugongzi.framework.model;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModelAndView {
    private final Map<String, Object> model;
    private final Set<Cookie> cookies;
    private String view;

    public ModelAndView(String v) {
        this.view = v;
        this.model = new HashMap<>();
        this.cookies = new HashSet<>();
    }

    public Set<Cookie> getCookies() {
        return cookies;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public void addCookie(Cookie cookie) {
        this.cookies.add(cookie);
    }

    public void addObject(String key, Object value) {
        this.model.put(key, value);
    }

    public Map<String, ?> getModel() {
        return model;
    }

}


