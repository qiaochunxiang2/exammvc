package com.sk.exammvc.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sk.exammvc.vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerMapper {
    @Select("select question, subject, score, section,level, \"选择题\" as type from multi_question " +
            "union select  question, subject, score, section,level, \"判断题\" as type  from judge_question " +
            "union select  question, subject, score, section,level, \"填空题\" as type from fill_question")
    IPage<AnswerVO> findAll(Page page);
}