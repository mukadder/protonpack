package com.codepoetics.protonpack;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

	public static void main(String[] args) {
		ConcurrentMap<String, String> map = new ConcurrentHashMap<>(1);
		for (int i = 0; i < 2; i++) {
			System.out.println(map.computeIfAbsent("a", Main::make));
		}

		AtomicReference<Optional<String>> ref = new AtomicReference<>(
				Optional.empty());
		for (int i = 0; i < 2; i++) {
			System.out.println(ref.updateAndGet(Main::make).get());
		}

	}

	public static Optional<String> make(Optional<String> opt) {
		return opt.isPresent() ? opt : Optional.of("bbb " + new Date());
	}

	public static String make(String key) {
		Date d = new Date();
		System.out.println(d);
		return "aaa " + d;
	}
}