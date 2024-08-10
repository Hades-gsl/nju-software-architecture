package com.hades.processor.starter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: Hades @Date: 2024/5/27 @Description:
 */
@Component
public class JobStarter implements CommandLineRunner {

  private JobLauncher jobLauncher;

  private Job job;

  @Autowired
  public JobStarter(JobLauncher jobLauncher, Job job) {
    this.jobLauncher = jobLauncher;
    this.job = job;
  }

  @Override
  public void run(String... args) throws Exception {
    JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
    jobLauncher.run(job, jobParameters);
  }
}
