package com.example.dbrouter.enums;


import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_ITEM_ID(400, "Invalid item ID"),
    ITEM_NOT_FOUND(404, "Item not found"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    ACTION_NOT_ALLOWED(403, "Action is not allowed");

    private final int code;
    private final String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
