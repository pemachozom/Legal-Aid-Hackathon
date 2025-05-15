package com.synchrotech.lac_datamanagement.models.Enums;

public enum CaseOutcome {
    WIN, // when the legal case has been decided in favor of the client
    LOSS, // when the legal case has been decided against the client
    SETTLED, // when the case is resolved through a settlement agreement between the parties
             // involved, without a court ruling
    DISMISSED // when the case is dismissed by the court. This can happen for various reasons,
              // such as lack of evidence, improper filing, jurisdictional issues, or mutual
              // agreement to drop the case.
}
