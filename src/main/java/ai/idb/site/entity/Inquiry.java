package ai.idb.site.entity;

import static ai.idb.site.exception.Preconditions.*;
import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.LAZY;

import ai.idb.site.support.entity.BaseIdEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "inquiry")
@Getter
@NoArgsConstructor
@Entity
public class Inquiry extends BaseIdEntity {

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "email_id")
    private Email to;

    @OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "inquery")
    private List<Email> carbonCopy = new ArrayList<>();

    @OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "inquery")
    private List<Email> blindCarbonCopy = new ArrayList<>();

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String position;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String contact;

    @Column(nullable = true)
    @Enumerated(STRING)
    private InquiryType inqueryType;

    @Column(nullable = true)
    @Lob
    private String contexts;

    public Inquiry(String companyName, String position, String name, String contact, String email, InquiryType inqueryType, String contexts) {

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
