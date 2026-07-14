package com.sai.emp.dto;

import java.math.BigDecimal;

public class SalaryUpdateRequestDto {

        private BigDecimal salary;

        public SalaryUpdateRequestDto() {
        }

        public SalaryUpdateRequestDto(BigDecimal salary) {
            this.salary = salary;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }


}
