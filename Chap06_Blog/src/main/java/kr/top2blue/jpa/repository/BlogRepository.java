package kr.top2blue.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import kr.top2blue.jpa.domain.Article;

public interface BlogRepository extends CrudRepository<Article, Long>{

}
