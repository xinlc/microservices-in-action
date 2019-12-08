package io.spring2go.zuul.hystrix;

import java.io.InputStream;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.netflix.client.ClientException;
import com.netflix.client.http.HttpResponse;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * A NIWS   Client Response
 * (this version just wraps Jersey Client response)
 * @author stonse
 *
 */
class HttpClientResponse implements HttpResponse {
    
    private ClientResponse bcr = null;
        
    private URI requestedURI; // the request url that got this response
    
    private Multimap<String, String> headers = ArrayListMultimap.<String, String>create();

    public HttpClientResponse(ClientResponse cr){
        bcr = cr;
        for (Map.Entry<String, List<String>> entry: bcr.getHeaders().entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                headers.putAll(entry.getKey(), entry.getValue());
            }
        }
    }

     /**
        * Returns the raw entity if available from the response 
        * @return
        * @throws IllegalArgumentException
        * @throws ClientException
        */
    public InputStream getRawEntity() throws ClientException{
        return bcr.getEntityInputStream();
    }
       
    
    public <T> T getEntity(Class<T> c) throws Exception {
        T t = null;
        try {
            t = this.bcr.getEntity(c);
        } catch (UniformInterfaceException e) {
            throw new ClientException(ClientException.ErrorType.GENERAL, e.getMessage(), e.getCause());
        } 
        return t;
    }

    @Override
    public Map<String, Collection<String>> getHeaders() {
        return headers.asMap();
    }

    public int getStatus() {
        return bcr.getStatus();
    }

    @Override
    public boolean isSuccess() {
        boolean isSuccess = false;
        ClientResponse.Status s = bcr != null? bcr.getClientResponseStatus(): null;
        isSuccess = s!=null? (s.getFamily() == javax.ws.rs.core.Response.Status.Family.SUCCESSFUL): false;
        return isSuccess;
    }

    public boolean hasEntity() {
        return bcr.hasEntity();
    }
        
    @Override
    public URI getRequestedURI() {
       return this.requestedURI;
    }
    
    public void setRequestedURI(URI requestedURI) {
        this.requestedURI = requestedURI;
    }

    @Override
    public Object getPayload() throws ClientException {
        if (hasEntity()) {
            return getRawEntity();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasPayload() {
        return hasEntity();        
    }
    
    public ClientResponse getJerseyClientResponse() {
        return bcr;
    }
    
    @Override
    public void close() {
        bcr.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getEntity(TypeToken<T> type) throws Exception {
        return (T) getEntity(type.getRawType());
    }

    @Override
    public InputStream getInputStream() throws ClientException {
        return getRawEntity();
    }
}
