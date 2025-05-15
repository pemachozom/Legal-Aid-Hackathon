package com.synchrotech.lac_datamanagement.models;

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
@Document(collection = "case_documents")
public class CaseDocuments {
    @Id
    private String document_id;
    @NotNull(message = "ipfs path cannot be null")
    private String ipfs_path;
    private String description;
    @NotNull(message = "case id cannot be null")
    private String case_id;
}
