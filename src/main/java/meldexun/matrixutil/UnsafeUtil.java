package meldexun.matrixutil;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeUtil {

	private static final Unsafe UNSAFE;

	static {
		UNSAFE = findUnsafe();
	}

	private static Unsafe findUnsafe() {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			return (Unsafe) field.get(null);
		} catch (ReflectiveOperationException e) {
			return null;
		}
	}

	public static Unsafe instance() {
		return UNSAFE;
	}

}
