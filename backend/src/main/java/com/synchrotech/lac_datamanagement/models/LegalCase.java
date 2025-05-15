package com.synchrotech.lac_datamanagement.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.synchrotech.lac_datamanagement.models.Enums.CaseStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "legal_cases")
public class LegalCase {
    @Id
    private String case_id;
    @NotNull(message = "description cannot be null")
    private String description;
    private String type;
    private CaseStatus status = CaseStatus.PENDING;
    @NotNull(message = "client id cannot be null")
    private String client_id;
    private String lawyer_id;
    private String documents_id;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    private LocalDateTime lawyer_assigned_at; // timestamp when a lawyer was assigned
    private boolean is_eligible; // whether the case is decided as eligible by admin
    private String ineligibility_reasons; // reasons for ineligibility if any
}