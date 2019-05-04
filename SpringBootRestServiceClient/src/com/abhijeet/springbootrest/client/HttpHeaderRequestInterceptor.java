package com.abhijeet.springbootrest.client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

public class HttpHeaderRequestInterceptor implements ClientHttpRequestInterceptor {
	private final String headerValue;

	public HttpHeaderRequestInterceptor(String headerValue) {
		this.headerValue = headerValue;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
		requestWrapper.getHeaders().setAccept(singletonList(MediaType.valueOf(headerValue)));
		requestWrapper.getHeaders().setContentType(MediaType.valueOf(headerValue));

		return execution.execute(requestWrapper, body);
	}

	private List<MediaType> singletonList(MediaType valueOf) {
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(valueOf);

		return list;
	}
}