package demo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import demo.domain.model.ModelUserInfo;
import demo.domain.model.ModelUserInfoExample;


//DBに書き込む処理に必要＠Repository
@Repository


@Mapper
public interface RepositoryUserInfo {

	long countByExample(ModelUserInfoExample example);

	int deleteByExample(ModelUserInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(ModelUserInfo record);

	int insertSelective(ModelUserInfo record);

	List<ModelUserInfo> selectByExample();

	List<ModelUserInfo> selectByExample(ModelUserInfoExample example);

	ModelUserInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") ModelUserInfo record,
			@Param("example") ModelUserInfoExample example);

	int updateByExample(@Param("record") ModelUserInfo record,
			@Param("example") ModelUserInfoExample example);

	int updateByPrimaryKeySelective(ModelUserInfo record);

	int updateByPrimaryKey(ModelUserInfo record);
}