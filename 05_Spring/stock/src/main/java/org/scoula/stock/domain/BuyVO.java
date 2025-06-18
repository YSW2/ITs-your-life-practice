package org.scoula.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BuyVO {
    private Long id;
    private String stockCode;
    private String stockName;
    private int price;
    private Date buyDate;
}
