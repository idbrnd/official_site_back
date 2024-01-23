package ai.idb.site.entity;

import static ai.idb.site.exception.Preconditions.*;
import static lombok.Lombok.checkNotNull;

import java.util.regex.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public final class Email {

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

	public static String toString(final Email email) {
		return email.email;
	}
}

