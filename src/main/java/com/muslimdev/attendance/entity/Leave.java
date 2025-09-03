package com.muslimdev.attendance.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "leave")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leave {

    private Long id;

    private String leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private String status;

    @ManyToOne()
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name = "approved_by")
    private Employee approvedBy;
}
