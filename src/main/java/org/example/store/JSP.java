package org.example.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JSP {
    AUTHENTICATION("authentication.jsp"),
    CALCULATOR_FIRST_NUMBER("calculatorFirstNumber.jsp"),
    CALCULATOR_SECOND_NUMBER("calculatorSecondNumber.jsp"),
    CALCULATOR_SUM("calculatorSum.jsp"),
    CART("cart.jsp"),
    CATALOG("catalog.jsp"),
    FILES_UPLOAD("filesUpload.jsp"),
    FILE_UPLOAD("fileUpload.jsp"),
    GET_ALL_EMPTY("getAllEmpty.jsp"),
    GET_ALL_PRODUCTS("getAllProducts.jsp"),
    HELLO("hello.jsp"),
    INDEX("index.jsp");

    private final String jspName;
}
