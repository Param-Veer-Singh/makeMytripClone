package com.makemytrip.makemytrip.models;


import com.makemytrip.makemytrip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;

    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private Double journeyTime;

    private String companyName;

    @ManyToOne
    @JoinColumn
    private Routes routes;

    @OneToMany(mappedBy = "transport", cascade = CascadeType.ALL)
    private List<Seat> seatList = new ArrayList<>();

    @OneToMany(mappedBy = "transport", cascade = CascadeType.ALL)
    private List<Bookings> bookings = new ArrayList<>();
}
