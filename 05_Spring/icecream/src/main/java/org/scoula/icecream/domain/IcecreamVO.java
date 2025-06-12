package org.scoula.icecream.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IcecreamVO {
    private int no;
    private String name;
    private String flavor;
    private int price;
    private Date regDate;
}
