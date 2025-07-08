package com.Bhavan.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LeaveRequestDto {
    private String reason;
    private LocalDate fromDate;
    private LocalDate toDate;
}
