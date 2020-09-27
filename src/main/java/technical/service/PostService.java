package technical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technical.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    public ArrayList<Post> getAllPosts(){
        ArrayList<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("Post 1");
        post.setBody("Body 1");
        post.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("Body 2");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setBody("Body 3");
        post3.setDate(new Date());

        posts.add(post);
        posts.add(post2);
        posts.add(post3);

        return posts;
    }

    public ArrayList<Post> getOnePost(){
        ArrayList<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("This is your first Post");
        post.setBody("This is your first body");
        post.setDate(new Date());

        posts.add(post);
        return posts;
    }
}
