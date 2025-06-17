package org.scoula.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StockVO {
    private int no;
    private String stockCode;
    private String stockName;
    private int price;
    private String description;
    private Date regDate;
}
