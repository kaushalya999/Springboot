package ijse.springIntroNew.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderReqDto {
    private List<Long> productIds;
}
