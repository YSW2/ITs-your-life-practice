package org.scoula.stock.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.stock.domain.BuyVO;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyDTO {
    private Long id;
    private String stockCode;
    private String stockName;
    private int price;
    private Date buyDate;

    public static BuyDTO of(BuyVO vo) {
        return vo == null ? null : BuyDTO.builder()
                .id(vo.getId())
                .stockCode(vo.getStockCode())
                .stockName(vo.getStockName())
                .price(vo.getPrice())
                .buyDate(vo.getBuyDate())
                .build();
    }

    // DTO  VO 변환
    public BuyVO toVo() {
        return BuyVO.builder()
                .id(id)
                .stockCode(stockCode)
                .stockName(stockName)
                .price(price)
                .buyDate(buyDate)
                .build();
    }
}
