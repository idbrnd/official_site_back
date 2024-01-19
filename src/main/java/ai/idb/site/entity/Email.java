package ai.idb.site.entity;

import ai.idb.site.support.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

import static ai.idb.site.exception.Preconditions.checkArgument;
import static ai.idb.site.exception.Preconditions.checkNotNull;
import static lombok.AccessLevel.PROTECTED;

@Table(name = "email")
@Getter
@NoArgsConstructor
@Entity
public class Email extends BaseIdEntity {

    private static final String EMAIL_REGEX =
            "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*" +
                    "@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)" +
                    "+[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Column(name = "email", length = 255)
    private String email;

    public Email(final String email) {
        checkNotNull(email, "Email cannot be null.");
        checkArgument(EMAIL_PATTERN.matcher(email).matches(), "이메일 형식이 잘못 되었습니다.");
        this.email = email;
    }

    // Assuming checkNotNull and checkArgument are defined elsewhere
    private void checkNotNull(Object reference, String errorMessage) {
        if (reference == null) {
            throw new NullPointerException(errorMessage);
        }
    }

    private void checkArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

