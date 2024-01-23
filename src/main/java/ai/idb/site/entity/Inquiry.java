package ai.idb.site.entity;

import static ai.idb.site.exception.Preconditions.*;
import static jakarta.persistence.EnumType.*;

import ai.idb.site.support.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "inquiry")
@Getter
@NoArgsConstructor
@Entity
public class Inquiry extends BaseIdEntity {

	@Column(nullable = true)
	private String companyName;

	@Column(nullable = true)
	private String position;

	@Column(nullable = true)
	private String name;

	@Column(nullable = true)
	private String contact;

	@Embedded
	private Email email;

	@Column(nullable = true)
	@Enumerated(STRING)
	private InquiryType inqueryType;

	@Column(nullable = true)
	@Lob
	private String contexts;

	public Inquiry(String companyName, String position, String name, String contact, String email,
		InquiryType inqueryType, String contexts) {

		checkNotNull(companyName);
		checkNotNull(name);
		checkNotNull(contact);
		checkNotNull(email);

		this.companyName = companyName;
		this.position = position;
		this.name = name;
		this.contact = contact;
		this.inqueryType = inqueryType;
		this.contexts = contexts;
	}
}
