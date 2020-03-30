package com.es2.bridge;
import java.util.HashMap;
import java.util.UUID;

public class APIRequest {
    HashMap<String,APIServiceInterface> services;

    public APIRequest() {
        services = new HashMap<String, APIServiceInterface>();
    }

    public String addService(APIServiceInterface service) {
        String id= UUID.randomUUID().toString();
        this.services.put(id, service);

        return id;
    }

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
        if(this.services.containsKey(serviceId))
            return this.services.get(serviceId).getContent(contentId);
        else
            throw new ServiceNotFoundException();
    }

    public String setContent(String serviceId, String content) throws ServiceNotFoundException {
        if(this.services.containsKey(serviceId))
            return this.services.get(serviceId).setContent(content);
        else
            throw new ServiceNotFoundException();
    }

}
