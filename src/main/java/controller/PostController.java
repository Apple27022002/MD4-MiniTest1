package controller;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.PostRepository;
import service.IPostService;

import java.awt.print.Pageable;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    IPostService postService;

    @GetMapping
    public ModelAndView show(ModelAndView modelAndView , @PageableDefault(value =4)Pageable pageable) {
        Page<Post> posts=postService.findAll(pageable);
        modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("post",posts);
        return modelAndView;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        Post post = postService.findById(id).get();
        modelAndView.addObject("po", post);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Long id, Post post) {
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");
        postService.save(post);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam String title) {
        ModelAndView modelAndView = new ModelAndView("/post/search");
        Iterable<Post> posts = postService.findAllByTitle(title);
        modelAndView.addObject("po", posts);
        return modelAndView;

    }

    @GetMapping("/reOder")
    public ModelAndView reOder() {
        ModelAndView modelAndView = new ModelAndView("/post/viewOder");
        Iterable<Post> posts = postService.reoderDesc();
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }
    @GetMapping("/oderTime")
    public ModelAndView timeOder(){
        ModelAndView modelAndView =new ModelAndView("/post/oderTime");
        Iterable<Post> posts=postService.oderByTime();
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }


    @PostMapping("/searchOder")
    public ModelAndView searchOder(@RequestParam(value="a") double a , @RequestParam(value="b") double b) {
        ModelAndView modelAndView = new ModelAndView("/post/searchByTimeAsc");
        Iterable<Post> posts =postService.findByRasingTimes(a,b);
        modelAndView.addObject("po",posts);
        return modelAndView;

    }





}
