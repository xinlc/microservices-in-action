package io.spring2go.zuul.mobile;

import javax.servlet.http.HttpServletResponse;

import io.spring2go.zuul.context.RequestContext;
import io.spring2go.zuul.filters.ZuulFilter;

public class HealthCheck extends ZuulFilter{

	@Override
	public String filterType() {
		return "pre";
	}
	
	public String uri() {
		return "/healthcheck";
	}
	
	@Override
	public boolean shouldFilter() {
		String path = RequestContext.getCurrentContext().getRequest().getRequestURI();
		return path.equalsIgnoreCase(uri());
	}
	
	public int filterOrder(){
		return 0;
	}
	
	public String responseBody() {
		return "<health>ok</health>";
	}
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		// Set the default response code for static filters to be 200
		ctx.getResponse().setStatus(HttpServletResponse.SC_OK);
		ctx.getResponse().setContentType("application/xml");
		// first StaticResponseFilter instance to match wins, others do not set body and/or status
		if (ctx.getResponseBody() == null) {
			ctx.setResponseBody(responseBody());
			ctx.setSendZuulResponse(false);
		}
		return null;
	}
}
