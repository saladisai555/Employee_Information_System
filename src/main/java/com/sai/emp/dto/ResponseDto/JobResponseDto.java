package com.sai.emp.dto.ResponseDto;

public class JobResponseDto {

        private Integer job_id;

        private String title;

        public JobResponseDto() {
        }

        public JobResponseDto(Integer job_id,
                              String title) {
            this.job_id = job_id;
            this.title = title;
        }

        public Integer getJobId() {
            return job_id;
        }

        public void setJobId(Integer job_id) {
            this.job_id = job_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

