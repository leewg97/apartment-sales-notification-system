package com.dev.be.aptbatch.core.entity;

import com.dev.be.aptbatch.core.dto.AptDealDto;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@DynamicUpdate
@Table(name = "apt")
@EntityListeners(AuditingEntityListener.class)
public class Apt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aptId;

    @Column(nullable = false)
    private String aptName;

    @Column(nullable = false)
    private String jibun;

    @Column(nullable = false)
    private String dong;

    @Column(nullable = false)
    private String guLawdCd;

    @Column(nullable = false)
    private Integer builtYear;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static Apt from(AptDealDto aptDealDto) {
        Apt apt = new Apt();
        apt.setAptName(aptDealDto.getAptName().trim());
        apt.setJibun(aptDealDto.getJibun().trim());
        apt.setDong(aptDealDto.getDong().trim());
        apt.setGuLawdCd(aptDealDto.getRegionalCode().trim());
        apt.setBuiltYear(aptDealDto.getBuiltYear());
        return apt;
    }

}
