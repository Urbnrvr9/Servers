package org.example.store;

import lombok.Getter;

@Getter
public enum JSP {
    AUTHENTICATION("authentication.jsp"),
    CALCULATOR_FIRST_NUMBER("calculatorFirstNumber.jsp"),
    CALCULATOR_SECOND_NUMBER("calculatorSecondNumber.jsp"),
    CALCULATOR_SUM("calculatorSum.jsp"),
    CART("cart.jsp"),
    CATALOG("catalog.jsp"),
    FILES_UPLOAD("filesUpload.jsp"),
    FILE_UPLOAD("fileUpload.jsp"),
    HELLO("hello.jsp"),
    INDEX("index.jsp");

    private final String jspName;

    JSP(String jspName) {
        this.jspName = jspName;
    }
}
