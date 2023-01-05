package com.live.kitchen.pugz_live_kitchen.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private Date timeStamp;

    private String message;
    private String details;
}
