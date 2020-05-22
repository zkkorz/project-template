package com.project.module.runner.transport;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回结果基础类
 */
@Data
@NoArgsConstructor
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = -5616252395124196455L;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 错误消息
     */
    private String errorMessage;

    /**
     * 状态码
     */
    private String responseCode;

    /**
     * 是否包含错误
     */
    private boolean hasError;

}
