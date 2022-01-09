package com.codecool.feb2021pl.springdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ExampleControllerTest {

    @Test
    public void testNewEmployee() {
        // Given
        EmployeeDao employeeDao = mock(EmployeeDao.class);
        EmployeeFactory employeeFactory = mock(EmployeeFactory.class);
        ExampleController sut = new ExampleController(employeeDao, employeeFactory);
        Employee employee = mock(Employee.class);
        given(employeeFactory.create("Józek")).willReturn(employee);

        // When
        sut.newEmployee("Józek");

        // Then
        verify(employeeDao).save(same(employee));
    }


}