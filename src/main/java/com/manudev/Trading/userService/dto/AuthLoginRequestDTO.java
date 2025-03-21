package com.manudev.Trading.userService.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequestDTO(@NotBlank String username, String password) {
}
