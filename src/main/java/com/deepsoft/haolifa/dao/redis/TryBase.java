package com.deepsoft.haolifa.dao.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class TryBase<T> {
	private static final Logger logger = LoggerFactory.getLogger(TryBase.class);

	@FunctionalInterface
	public static interface Callable<T> {
		T apply() throws Exception;
	}

	@FunctionalInterface
	public static interface Runnable {
		void apply() throws Exception;
	}

	public static class TryFailedException extends RuntimeException {

		private static final long serialVersionUID = 949971009834130526L;

		TryFailedException(Exception e) {
			super(e);
		}

		TryFailedException(String message) {
			super(message);
		}
	}

	public static <T> TryBase<T> ofc(Callable<T> callable) {
		try {
			TryBase<T> success = TryBase.success(callable.apply());
			// logger.info("TryBase success operation");
			return success;
		} catch (Exception e) {
			logger.error("TryBase error operation");
			return TryBase.failed(e);
		}
	}

	public static <T> TryBase<T> ofc(int times, Callable<T> callable) {
		if (times <= 0) {
			throw new TryFailedException("times accept positive number");
		}

		TryBase<T> ofc = null;
		for (int i = 0; i < times; i++) {
			ofc = ofc(callable);

			if (ofc.isSuccess()) {
				break;
			}
		}

		return ofc;
	}

	public static TryBase<Void> ofr(Runnable runnable) {
		try {
			runnable.apply();
			return TryBase.success(null);
		} catch (Exception e) {
			return TryBase.failed(e);
		}
	}

	public static TryBase<Void> ofr(int times, Runnable runnable) {
		if (times <= 0) {
			throw new TryFailedException("times accept positive number");
		}

		TryBase<Void> ofr = null;
		for (int i = 0; i < times; i++) {
			ofr = ofr(runnable);
			if (ofr.isSuccess()) {
				break;
			}
		}

		return ofr;
	}

	public static void tryRun(Runnable runnable) throws TryFailedException {
		try {
			runnable.apply();
		} catch (Exception e) {
			throw new TryFailedException(e);
		}
	}

	/**
	 * @param runnable
	 * @return java.lang.Runnable throw TryFailedException while has Exception
	 */
	public static java.lang.Runnable toThreadRun(Runnable runnable) {
		return () -> {
			try {
				runnable.apply();
			} catch (Exception e) {
				throw new TryFailedException(e);
			}
		};
	}

	private Exception cause = null;
	private T result = null;

	private static <T> TryBase<T> failed(Exception e) {
		TryBase<T> impl = new TryBase<T>();
		impl.cause = e;
		return impl;
	}

	private static <T> TryBase<T> success(T result) {
		TryBase<T> impl = new TryBase<T>();
		impl.result = result;
		return impl;
	}

	public boolean isFailed() {
		return !isSuccess();
	}

	public T orElse(T other) {
		return isSuccess() ? get() : other;
	}

	public T orElseGet(Supplier<T> supplier) {
		return isSuccess() ? get() : supplier.get();
	}

	public boolean isSuccess() {
		return null == cause;
	}

	public Exception getCause() {
		return cause;
	}

	public T get() {
		if (isFailed())
			throw new TryFailedException(cause);
		return result;
	}
}
