package com.synchrotech.lac_datamanagement.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hearings")
public class Hearing {
    @Id
    private String hearing_id;
    @NotNull(message = "title cannot be null")
    private String title;
    private String description;
    @NotNull(message = "hearing date and time cannot be null")
    private LocalDateTime datetime;
    @NotNull(message = "hearing venue cannot be null")
    private String venue;
    @NotNull(message = "case id cannot be null")
    private String case_id;
}
