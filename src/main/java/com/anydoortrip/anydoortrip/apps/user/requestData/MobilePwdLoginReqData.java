package com.anydoortrip.anydoortrip.apps.user.requestData;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 电话号码密码登录数据
 */
@Data
public class MobilePwdLoginReqData {
    /**
     * 电话号码
     */
    @NotNull(message = "电话号码不可为空")
    private String mobile;
    /**
     * 密码
     */
    @NotNull(message = "密码不可为空")
    private String password;
    /**
     * 是否保持登录
     */
    private Integer remember;

    public Integer getRemember() {
        return remember == null ? 0 : remember;
    }
}
