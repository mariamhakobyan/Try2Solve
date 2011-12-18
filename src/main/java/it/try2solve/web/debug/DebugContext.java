package it.try2solve.web.debug;

import java.util.HashMap;

public class DebugContext {
	
	private static final ThreadLocal<HashMap<String, String>> debugger = new ThreadLocal<HashMap<String, String>>() {
		@Override
		protected HashMap<String, String> initialValue() {
			return new HashMap<String, String>();
		}
	};

	public static void put(String key, String value) {
		debugger.get().put(key, value);
	}

	public static void put(String key, int value) {
		debugger.get().put(key, String.valueOf(value));
	}

	public static void put(String key, long value) {
		debugger.get().put(key, String.valueOf(value));
	}

	public static void put(String key, double value) {
		debugger.get().put(key, String.valueOf(value));
	}

	public static HashMap<String, String> getMap() {
		return debugger.get();
	}
	
	public static String get(String key) {
		return debugger.get().get(key);
	}
	
	public static void remove(String key) {
		debugger.get().remove(key);
	}

}
