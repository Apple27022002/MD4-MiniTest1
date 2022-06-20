package service;

import model.Post;

public interface IPostService extends IGeneralService<Post>{
    Iterable<Post> findAllByTitle(String title);
    Iterable<Post> reoderDesc();
    Iterable<Post> oderByTime();
    Iterable<Post> findByRasingTimes(double a, double b);
}
