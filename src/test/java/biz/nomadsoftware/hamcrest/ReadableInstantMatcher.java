package biz.nomadsoftware.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.joda.time.ReadableInstant;

// TODO move to separate library
public class ReadableInstantMatcher {

	/**
	 * @param readableInstant
	 * @see org.joda.time.ReadableInstant#isBefore(org.joda.time.ReadableInstant)
	 */
	@Factory
	public static Matcher<ReadableInstant> isBefore(ReadableInstant readableInstant) {
		return new ReadableInstantBefore(readableInstant);
	}

	/**
	 * @param readableInstant
	 * @see org.joda.time.ReadableInstant#isAfter(org.joda.time.ReadableInstant)
	 */
	@Factory
	public static Matcher<ReadableInstant> isAfter(ReadableInstant readableInstant) {
		return new ReadableInstantAfter(readableInstant);
	}

	/**
	 * @param readableInstant
	 * @see org.joda.time.ReadableInstant#equals(org.joda.time.ReadableInstant)
	 */
	@Factory
	public static Matcher<ReadableInstant> equals(ReadableInstant readableInstant) {
		return new ReadableInstantEquals(readableInstant);
	}

	private static class ReadableInstantBefore extends TypeSafeMatcher<ReadableInstant> {

		private final ReadableInstant rhs;

		ReadableInstantBefore(ReadableInstant readableInstant) {
			rhs = readableInstant;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("isBefore ").appendValue(rhs);
		}

		@Override
		protected boolean matchesSafely(ReadableInstant lhs) {
			return lhs.isBefore(rhs);
		}

	}

	private static class ReadableInstantAfter extends TypeSafeMatcher<ReadableInstant> {

		private final ReadableInstant rhs;

		ReadableInstantAfter(ReadableInstant readableInstant) {
			rhs = readableInstant;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("isAfter ").appendValue(rhs);
		}

		@Override
		protected boolean matchesSafely(ReadableInstant lhs) {
			return lhs.isAfter(rhs);
		}

	}

	private static class ReadableInstantEquals extends TypeSafeMatcher<ReadableInstant> {

		private final ReadableInstant rhs;

		ReadableInstantEquals(ReadableInstant readableInstant) {
			rhs = readableInstant;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("isEqual ").appendValue(rhs);
		}

		@Override
		protected boolean matchesSafely(ReadableInstant lhs) {
			return lhs.isEqual(rhs);
		}

	}
}

