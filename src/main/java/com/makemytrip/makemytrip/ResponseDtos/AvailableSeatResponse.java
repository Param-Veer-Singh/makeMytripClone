package com.makemytrip.makemytrip.ResponseDtos;

import com.makemytrip.makemytrip.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailableSeatResponse {

    private String seatNo;
    private SeatType seatType;
    private Integer seatPrice;

}
