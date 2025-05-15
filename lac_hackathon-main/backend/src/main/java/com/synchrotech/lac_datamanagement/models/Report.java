package com.synchrotech.lac_datamanagement.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.synchrotech.lac_datamanagement.models.Enums.CaseOutcome;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reports")
public class Report {
    @Id
    private String report_id;
    @NotNull(message = "settlement summary cannot be null")
    private String settlementSummary;
    @NotNull(message = "settlement date cannot be null")
    private LocalDate settlementDate;
    private String judgementDetails;
    @NotNull(message = "case outcome cannot be null")
    private CaseOutcome outcome;
    private String clientComments;
    private String finalSettlementDocument; // this gon be an ipfs path as well
    private String lawyerAdditionalComments;
}
