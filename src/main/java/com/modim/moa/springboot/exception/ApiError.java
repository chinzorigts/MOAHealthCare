package com.modim.moa.springboot.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ApiError {

    //결과 스타토스
    private final HttpStatus httpStatus;
    //결과 코드
    private final int resultCode;
    //결과 코드 메시지
    private final String resultMessage;
    //결과 내용
    private final String resultDetail;
    //시스템 에러 메시지
    private final String resultErrMessage;
    //에러 시간
    private final LocalDateTime errorTime;

    public ApiError(HttpStatus httpStatus, String resultMessage, String resultDetail, Throwable exception) {
        this.httpStatus = httpStatus;
        this.resultCode = httpStatus.value();
        this.resultMessage = resultMessage;
        this.resultDetail = resultDetail;
        this.resultErrMessage = exception.getLocalizedMessage();
        this.errorTime = LocalDateTime.now();
    }
}
