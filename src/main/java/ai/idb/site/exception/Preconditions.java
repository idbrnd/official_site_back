package ai.idb.site.exception;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class Preconditions {
    public static void checkNotNull(final Object target) {
        if (target == null) {
            throw new NullPointerException();
        }
    }

    public static void checkArgument(final boolean expression, final String errorMessage, final Object... args) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(errorMessage, args));
        }
    }
}
