package com.example.arsteam.exception;

import lombok.Getter;

public enum ExceptionCode {
    NOT_FOUND_MEASURES(404,"측정값이 존재하지 않습니다."),
    NOT_FOUND_DEVICE(404,"디바이스가 존재하지 않습니다."  );

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}