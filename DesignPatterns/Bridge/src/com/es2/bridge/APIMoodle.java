package com.es2.bridge;

import java.util.LinkedHashMap;
import java.util.UUID;

public class APIMoodle extends Object implements APIServiceInterface{
    LinkedHashMap<String,String> content;

    public APIMoodle() {
        content = new LinkedHashMap<String, String>();
    }

    public String getContent(String contentId) {
        if(contentId.equals("0")) {
            String conc = "";

            for (String key : content.keySet())
                conc += content.get(key);
            return conc;
        }
        else
            return content.get(contentId);
    }

    public String setContent(String content) {
        String id= UUID.randomUUID().toString();
        this.content.put(id, content);

        return id;
    }
}
