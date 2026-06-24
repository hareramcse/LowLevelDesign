package com.hs;

public class UrlShortenerTest {
	public static void main(String[] args) {
		UrlShortener shortener = UrlShortener.getInstance();

		String longUrl = "https://example.com/articles/low-level-design-interview";
		String code = shortener.shorten(longUrl);
		System.out.println("Short code: " + code);

		shortener.resolve(code).ifPresentOrElse(
				url -> System.out.println("Resolved: " + url),
				() -> System.out.println("Not found"));

		// same URL returns same code
		System.out.println("Same URL again: " + shortener.shorten(longUrl));
	}
}
