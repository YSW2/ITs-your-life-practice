package org.scoula.stock.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.stock.domain.StockVO;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StockDTO {
    private int no;
    private String stockCode;
    private String stockName;
    private int price;
    private String description;
    private Date regDate;

    // VO  DTO 변환
    public static StockDTO of(StockVO vo) {
        return vo == null ? null : StockDTO.builder()
                .no(vo.getNo())
                .stockCode(vo.getStockCode())
                .stockName(vo.getStockName())
                .price(vo.getPrice())
                .description(vo.getDescription())
                .regDate(vo.getRegDate())
                .build();
    }

    // DTO  VO 변환
    public StockVO toVo() {
        return StockVO.builder()
                .no(no)
                .stockCode(stockCode)
                .stockName(stockName)
                .price(price)
                .description(description)
                .regDate(regDate)
                .build();
    }

}
