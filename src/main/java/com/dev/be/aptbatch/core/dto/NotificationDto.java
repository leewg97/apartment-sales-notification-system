package com.dev.be.aptbatch.core.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.util.Pair;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class NotificationDto {

    private String email;
    private String guName;
    private Integer count;
    private List<AptDto> aptDeals;

    public String toMessage() {
        DecimalFormat decimalFormat = new DecimalFormat();
        return String.format("%s 아파트 실거래가 알림\n" +
                "총 %s게 거래가 발생했습니다.\n", guName, count)
                +
                aptDeals.stream()
                        .map(deal -> String.format("- %s : %s만원\n", deal.getName(), decimalFormat.format(deal.getPrice())))
                        .collect(Collectors.joining());
    }

}
