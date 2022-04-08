package com.mc.mcsoul.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class AjaxJson extends HashMap<String, Object> {
    public AjaxJson() {
        this.put("success", true);
        this.put("code", HttpStatus.OK.value());
        this.put("msg", "操作成功");
    }
    public String getMsg() {
        return (String)this.get("msg");
    }

    public void setMsg(String msg) {
        this.put("msg", msg);
    }

    public boolean isSuccess() {
        return (Boolean)this.get("success");
    }

    public void setSuccess(boolean success) {
        this.put("success", success);
    }


    @JsonIgnore
    public static AjaxJson success(String msg) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setMsg(msg);
        return ajaxJson;
    }

    @JsonIgnore
    public static AjaxJson error(String msg) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setSuccess(false);
        ajaxJson.setMsg(msg);
        return ajaxJson;
    }

    public static AjaxJson success(Map<String, Object> map) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.putAll(map);
        return ajaxJson;
    }

    public static AjaxJson success() {
        return new AjaxJson();
    }

    public AjaxJson put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public AjaxJson putMap(Map m) {
        super.putAll(m);
        return this;
    }

    public int getCode() {
        return (Integer)this.get("code");
    }

    public void setCode(int code) {
        this.put("code", code);
    }
}
