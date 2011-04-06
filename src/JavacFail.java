import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author richard
 * 
 */
public class JavacFail {

	public static void main(final String[] args) {

		System.out.println(filter(asList(1, 2, 3), or(gt(2), lt(2))));

	}

	static List<Integer> filter(final List<Integer> old, final Predicate<Integer> f) {
		final List<Integer> data = new ArrayList<Integer>();
		for (final Integer integer : old) {
			if (f.apply(integer)) {
				data.add(integer);
			}
		}
		return data;
	}

	static Predicate<Integer> lt(final int val) {
		return new Predicate<Integer>() {
			@Override
			public boolean apply(final Integer t) {
				return t < val;
			}
		};
	}

	static Predicate<Integer> gt(final int val) {
		return new Predicate<Integer>() {
			@Override
			public boolean apply(final Integer t) {
				return t > val;
			}
		};
	}

	static <T> Predicate<T> or(final Predicate<? super T>... args) {
		return new Predicate<T>() {
			@Override
			public boolean apply(final T t) {
				for (final Predicate<? super T> predicate : args) {
					if (predicate.apply(t)) {
						return true;
					}
				}
				return false;
			}
		};
	}

}

interface Predicate<T> {

	public boolean apply(T t);

}