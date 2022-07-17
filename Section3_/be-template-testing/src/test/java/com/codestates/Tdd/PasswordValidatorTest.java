package com.codestates.Tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    @DisplayName("패스워드 유효성 검증 테스트: 모든 조건에 만족")
    @Test
    public void validatePassword() {
        String password = "ABCD1234!";

        PasswordValidator validator = new PasswordValidator();
        Executable excutable = () -> validator.validate(password);

        assertDoesNotThrow(excutable);
    }

    @DisplayName("특수 문자 포함 안됨 테스트")
    @Test
    public void validatePasswordWithoutSpecialCharacter() {
        // given
        String password = "Abcd1234&";
        String password2 = "Abcd1234";

        // when
        PasswordValidator validator = new PasswordValidator();
        Executable executable = () -> validator.validate(password);
        Executable executable2 = () -> validator.validate(password2);

        // then
        assertDoesNotThrow(executable);
        assertDoesNotThrow(executable2);

    }
}
