package com.dev.be.aptbatch.core.dto;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 아파트 실거래가 API 각각의 거래 정보를 담는 객체
 */
@Getter
@ToString
@XmlRootElement(name = "item")
public class AptDealDto {

    @XmlElement(name = "거래금액")
    private String dealAmount;

    @XmlElement(name = "건축년도")
    private Integer builtYear;

    @XmlElement(name = "년")
    private Integer year;

    @XmlElement(name = "법정동")
    private String dong;

    @XmlElement(name = "아파트")
    private String aptName;

    @XmlElement(name = "월")
    private Integer month;

    @XmlElement(name = "일")
    private Integer day;

    @XmlElement(name = "전용면적")
    private Double exclusiveArea;

    @XmlElement(name = "지번")
    private String jibun;

    @XmlElement(name = "지역코드")
    private String regionalCode;

    @XmlElement(name = "층")
    private Integer floor;

    @XmlElement(name = "해제사유발생일")
    private String dealCanceledDate;

    @XmlElement(name = "해제여부")
    private String dealCanceled;

    public LocalDate getDealDate() {
        return LocalDate.of(year, month, day);
    }

    public Long getDealAmount() {
        return Long.parseLong(dealAmount.replaceAll(",", "").trim());
    }

    public LocalDate getDealCanceledDate() {
        if (StringUtils.isBlank(dealCanceledDate)) {
            return null;
        }
        return LocalDate.parse(dealCanceledDate.trim(), DateTimeFormatter.ofPattern("yy.MM.dd"));
    }

    public boolean isDealCanceled() {
        return "O".equals(dealCanceled);
    }

}
