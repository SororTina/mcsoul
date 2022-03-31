package com.mc.mcsoul.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class AjaxJson extends HashMap<String, Object> {
    public AjaxJson() {
        this.put((String)"success", true);
        this.put((String)"code", HttpStatus.OK.value());
        this.put((String)"msg", "操作成功");
    }
    public String getMsg() {
        return (String)this.get("msg");
    }

    public void setMsg(String msg) {
        this.put((String)"msg", msg);
    }

    public boolean isSuccess() {
        return (Boolean)this.get("success");
    }

    public void setSuccess(boolean success) {
        this.put((String)"success", success);
    }


    @JsonIgnore
    public static AjaxJson success(String msg) {
        AjaxJson j = new AjaxJson();
        j.setMsg(msg);
        return j;
    }

    @JsonIgnore
    public static AjaxJson error(String msg) {
        AjaxJson j = new AjaxJson();
        j.setSuccess(false);
        j.setMsg(msg);
        return j;
    }

    public static AjaxJson success(Map<String, Object> map) {
        AjaxJson restResponse = new AjaxJson();
        restResponse.putAll(map);
        return restResponse;
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
        this.put((String)"code", code);
    }
}
