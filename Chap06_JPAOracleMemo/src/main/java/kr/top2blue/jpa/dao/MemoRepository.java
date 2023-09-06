package kr.top2blue.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import kr.top2blue.jpa.vo.Memo;

public interface MemoRepository extends CrudRepository<Memo, Integer>{

}
