package service.ipml;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import repository.PostRepository;
import service.IPostService;

import java.awt.print.Pageable;
import java.util.Optional;

public class PostService implements IPostService {
    @Autowired
    PostRepository postRepository;
//    @Override
//    public Iterable findAll() {
//        return postRepository.findAll();
//    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional findById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Iterable<Post> findAllByTitle(String title) {
        return postRepository.findAllByTitleContaining(title);
    }

    @Override
    public Iterable<Post> reoderDesc() {
        return postRepository.abc();
    }

    @Override
    public Iterable<Post> oderByTime() {
        return postRepository.ecec();
    }

    @Override
    public Iterable<Post> findByRasingTimes(double a,double b) {
        return postRepository.findByRasingTimes(a,b);
    }


}
