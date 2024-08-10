package com.hades.processor.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hades.processor.mapper.ProductMapper;
import com.hades.processor.mapper.ReviewMapper;
import com.hades.processor.mapper.UserMapper;
import com.hades.processor.model.Product;
import com.hades.processor.model.RawProduct;
import com.hades.processor.model.Review;
import com.hades.processor.model.User;
import lombok.Data;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @Author: Hades @Date: 2024/5/26 @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "data")
@Data
public class SpringBatchConfig {
  private String directory;
  private String[] dFiles;
  private String[] mFiles;

  @Bean
  public ItemReader<Review> itemReader() {
    FlatFileItemReader<Review> reader = new FlatFileItemReader<>();
    reader.setResource(new FileSystemResource(directory + dFiles[0]));
    reader.setLineMapper(
        (line, lineNumber) -> {
          ObjectMapper objectMapper = new ObjectMapper();
          return objectMapper.readValue(line, Review.class);
        });
    return reader;
  }

  @Bean
  public ItemReader<RawProduct> itemReader2() {
    FlatFileItemReader<RawProduct> reader = new FlatFileItemReader<>();
    reader.setResource(new FileSystemResource(directory + mFiles[0]));
    reader.setLineMapper(
        (line, lineNumber) -> {
          ObjectMapper objectMapper = new ObjectMapper();
          return objectMapper.readValue(line, RawProduct.class);
        });
    return reader;
  }

  public void simulateLoad(int iterations) {
    for (int i = 0; i < iterations; i++) {
      fibonacci(i);
    }
  }

  private int fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  @Bean
  public ItemProcessor<Review, Review> itemProcessor() {
    return review -> {
      simulateLoad(10);
      return review;
    };
  }

  @Bean
  public ItemProcessor<RawProduct, Product> itemProcessor2() {
    return rawProduct -> {
      Product product = new Product();
      product.setMainCategory(rawProduct.getMainCategory());
      product.setTitle(rawProduct.getTitle());
      product.setAverageRating(rawProduct.getAverageRating());
      product.setRatingNumber(rawProduct.getRatingNumber());
      product.setDescription(String.join(" ", rawProduct.getDescription()));
      product.setPrice(rawProduct.getPrice());
      product.setImage(rawProduct.getImages().getFirst().getOrDefault("large", ""));
      product.setParentAsin(rawProduct.getParentAsin());

      simulateLoad(10);

      return product;
    };
  }

  @Bean
  public ItemWriter<Review> itemWriter(ReviewMapper reviewMapper, UserMapper userMapper) {
    return items -> {
      for (Review item : items) {
        reviewMapper.insertReview(item);
        userMapper.insertUser(new User(item.getUserId()));
      }
    };
  }

  @Bean
  public ItemWriter<Product> itemWriter2(ProductMapper productMapper) {
    return items -> {
      for (Product item : items) {
        productMapper.insertProduct(item);
      }
    };
  }

  @Bean
  public Step step1(
      JobRepository jobRepository,
      PlatformTransactionManager transactionManager,
      ItemReader<Review> itemReader,
      ItemProcessor<Review, Review> itemProcessor,
      ItemWriter<Review> itemWriter) {
    return new StepBuilder("step1", jobRepository)
        .<Review, Review>chunk(100, transactionManager)
        .reader(itemReader)
        .processor(itemProcessor)
        .writer(itemWriter)
        .build();
  }

  @Bean
  public Step step2(
      JobRepository jobRepository,
      PlatformTransactionManager transactionManager,
      ItemReader<RawProduct> itemReader2,
      ItemProcessor<RawProduct, Product> itemProcessor2,
      ItemWriter<Product> itemWriter2) {
    return new StepBuilder("step2", jobRepository)
        .<RawProduct, Product>chunk(100, transactionManager)
        .reader(itemReader2)
        .processor(itemProcessor2)
        .writer(itemWriter2)
        .build();
  }

  @Bean
  public Job job(JobRepository jobRepository, Step step1, Step step2) {
    return new JobBuilder("job", jobRepository).start(step1).build();
  }
}
