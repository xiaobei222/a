package com.anydoortrip.anydoortrip.apps.hotel.requestData;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 城市查询参数
 */
@Data
public class CitySearchReqData {
    @NotNull(message = "关键字不可为空")
    private String keyword;
}
