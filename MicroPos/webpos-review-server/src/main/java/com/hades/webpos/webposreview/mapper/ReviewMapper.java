package com.hades.webpos.webposreview.mapper;

import com.hades.webpos.webposreview.model.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@Mapper
public interface ReviewMapper {
    @Select("SELECT * FROM review WHERE parentAsin = #{asin}")
    List<Review> getReviews(String asin);
}
