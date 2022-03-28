package com.architecture.hexagonal.transaction.adapters.infra.error.exceptions;

import com.architecture.hexagonal.transaction.adapters.infra.error.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails {
}
