package com.deepsoft.haolifa.utils;

import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class HttpClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	private final static String charset = "UTF-8";

	public static String doGet(String url, Map<String, String> param, Map<String, String> headers) {
		String resultString = "";
		final HttpMethod request = new HttpMethod(url, param, headers);
		resultString = doRequest(request, req -> buildGetRequest(req));
		return resultString;
	}

	public static String doGet(String url, Map<String, String> param) {
		return doGet(url, param, null);
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param, Map<String, String> headers) {
		String resultString = "";
		final HttpMethod request = new HttpMethod(url, param, headers);
		resultString = doRequest(request, req -> buildPostRequest(req));
		return resultString;
	}

	public static String doPost(String url, Map<String, String> param) {
		return doPost(url, param, null);
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}

	public static String doPostJson(String url, String json, Map<String, String> headers) {
		String resultString = "";
		final HttpMethod request = new HttpMethod(url, json, headers);
		resultString = doRequest(request, req -> buildPostJsonRequest(req));
		return resultString;
	}

	public static String doPostJson(String url, String json) {
		return doPostJson(url, json, null);
	}

	private static String doRequest(HttpMethod request, Function<HttpMethod, HttpRequestBase> function) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			HttpRequestBase httpRequest = function.apply(request);
			httpClient = httpClient();
			response = httpClient.execute(httpRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= HttpStatus.SC_OK && statusCode < HttpStatus.SC_MULTIPLE_CHOICES) {
				resultString = EntityUtils.toString(response.getEntity(), charset);
			}
		} catch (Exception e) {
			logger.error("doRequest erro: ", e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				logger.error("doRequest close erro: ", e);
			}
		}
		return resultString;
	}

	private static HttpRequestBase buildGetRequest(HttpMethod request) {
		try {
			return buildGetRequest(request.getUrl(), request.getParam(), request.getHeaders());
		} catch (Exception e) {
			logger.error("buildGetRequest erro: ", e);
		}
		return null;
	}

	private static HttpGet buildGetRequest(String url, Map<String, String> param, Map<String, String> headers) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(url);
		if (MapUtils.isNotEmpty(param)) {
			for (String key : param.keySet()) {
				builder.addParameter(key, param.get(key));
			}
		}
		URI uri = builder.build();
		HttpGet httpGet = new HttpGet(uri);
		if (MapUtils.isNotEmpty(headers)) {
			for (String key : headers.keySet()) {
				httpGet.setHeader(key, headers.get(key));
			}
		}
		return httpGet;
	}

	private static HttpRequestBase buildPostRequest(HttpMethod request) {
		try {
			return buildPostRequest(request.getUrl(), request.getParam(), request.getHeaders());
		} catch (Exception e) {
			logger.error("buildPostRequest erro: ", e);
		}
		return null;
	}

	private static HttpPost buildPostRequest(String url, Map<String, String> param, Map<String, String> headers) throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(url);
		if (MapUtils.isNotEmpty(param)) {
			List<NameValuePair> paramList = new ArrayList<>();
			for (String key : param.keySet()) {
				paramList.add(new BasicNameValuePair(key, param.get(key)));
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, charset);
			httpPost.setEntity(entity);
		}
		if (MapUtils.isNotEmpty(headers)) {
			for (String key : headers.keySet()) {
				httpPost.setHeader(key, headers.get(key));
			}
		}
		return httpPost;
	}

	private static HttpRequestBase buildPostJsonRequest(HttpMethod request) {
		try {
			return buildPostJsonRequest(request.getUrl(), request.getJson(), request.getHeaders());
		} catch (Exception e) {
			logger.error("buildPostJsonRequest erro: ", e);
		}
		return null;
	}

	private static HttpPost buildPostJsonRequest(String url, String json, Map<String, String> headers) {
		HttpPost httpPost = new HttpPost(url);
		if (MapUtils.isNotEmpty(headers)) {
			for (String key : headers.keySet()) {
				httpPost.setHeader(key, headers.get(key));
			}
		}
		StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
		httpPost.setEntity(entity);
		return httpPost;
	}

	private static CloseableHttpClient httpClient() throws KeyManagementException, NoSuchAlgorithmException {
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE).register("https", new SSLConnectionSocketFactory(enableTrustTLS())).build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(connManager);
		return httpClientBuilder.build();
	}

	private static SSLContext enableTrustTLS() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext context = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		context.init(null, new TrustManager[] { trustManager }, null);
		return context;
	}

	static class HttpMethod {
		private String url;
		private String json;
		private Map<String, String> param;
		private Map<String, String> headers;

		public HttpMethod() {
		}

		public HttpMethod(String url, Map<String, String> param, Map<String, String> headers) {
			this.url = url;
			this.param = param;
			this.headers = headers;
		}

		public HttpMethod(String url, String json, Map<String, String> headers) {
			this.url = url;
			this.json = json;
			this.headers = headers;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getJson() {
			return json;
		}

		public void setJson(String json) {
			this.json = json;
		}

		public Map<String, String> getParam() {
			return param;
		}

		public void setParam(Map<String, String> param) {
			this.param = param;
		}

		public Map<String, String> getHeaders() {
			return headers;
		}

		public void setHeaders(Map<String, String> headers) {
			this.headers = headers;
		}

	}
}
