package seedu.address.model.classgroup;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a ClassGroup's ID in TAssist.
 * Guarantees: immutable; is valid as declared in {@link #isValidClassGroupId(String)}
 */
public class ClassGroupId {
    public static final String MESSAGE_CONSTRAINTS =
            "CLass Group ID should only contain numbers, and it should be at least 1 digit long";
    // currently supports numerals only
    public static final String VALIDATION_REGEX = "\\d{1,2}";
    public final String value;

    /**
     * Constructs a {@code ClassGroupId}.
     *
     * @param classGroupId A valid class group ID.
     */
    public ClassGroupId(String classGroupId) {
        requireNonNull(classGroupId);
        checkArgument(isValidClassGroupId(classGroupId), MESSAGE_CONSTRAINTS);
        value = classGroupId;
    }

    /**
     * Returns true if a given string is a valid class group ID.
     */
    public static boolean isValidClassGroupId(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof ClassGroupId
                && value.equals(((ClassGroupId) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}