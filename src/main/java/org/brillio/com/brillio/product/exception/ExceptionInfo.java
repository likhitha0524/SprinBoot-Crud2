package org.brillio.com.brillio.product.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionInfo {

    private String url;
    private String errorMessage;
}
