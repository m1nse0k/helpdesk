package com.minseok.helpdesk.common;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException e) {
        log.warn("잘못된 요청: {}", e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleNotReadable(HttpMessageNotReadableException e) {
        log.warn("요청 본문을 읽을 수 없음: {}", e.getMessage());   // 서버 기록: 자세하게 OK
        return ResponseEntity
                .badRequest()                                          // TODO 1: 상태 코드 400
                .body(new ErrorResponse("요청 형식이 올바르지 않습니다. 입력값을 확인해주세요."));       // TODO 2: 사용자용 고정 문구
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception e) {
        log.error("예상하지 못한 오류", e);       // ← e를 통째로! 스택 트레이스까지 기록
        return ResponseEntity
                .internalServerError()             // 상태 코드 500
                .body(new ErrorResponse("일시적인 오류가 발생했습니다. 잠시 후 다시 시도하거나 관리자에게 문의해주세요."));   // TODO: 사용자용 고정 문구
    }
}