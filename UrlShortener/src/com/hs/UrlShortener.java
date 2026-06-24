package com.hs;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UrlShortener {
	private static UrlShortener instance;
	private final Map<String, String> codeToUrl = new HashMap<>();
	private final Map<String, String> urlToCode = new HashMap<>();
	private final AtomicLong counter = new AtomicLong(1);

	private UrlShortener() {
	}

	public static synchronized UrlShortener getInstance() {
		if (instance == null) {
			instance = new UrlShortener();
		}
		return instance;
	}

	public String shorten(String longUrl) {
		if (urlToCode.containsKey(longUrl)) {
			return urlToCode.get(longUrl);
		}
		String code = Base62Encoder.encode(counter.getAndIncrement());
		codeToUrl.put(code, longUrl);
		urlToCode.put(longUrl, code);
		return code;
	}

	public Optional<String> resolve(String code) {
		return Optional.ofNullable(codeToUrl.get(code));
	}
}
