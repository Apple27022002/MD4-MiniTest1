package repository;

import model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

    Iterable<Post> findAllByTitleContaining(String title);

    @Query(value = "from Post order by likes")
    Iterable<Post> abc();

    @Query(value = "select * from post order by createAt DESC limit 4", nativeQuery = true)
    Iterable<Post> ecec();

    @Query(value = "select * from post p WHERE( p.createAt between :a and :b) order by id  ", nativeQuery = true)
    Iterable<Post> findByRasingTimes(@Param("a") double a, @Param("b") double b);
}
