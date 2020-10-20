package technical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technical.model.Post;
import technical.repository.PostRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts(){
        return repository.getAllPosts();
    }

    public Post getOnePost(){
        return repository.getLatestPost();
    }

    /*public ArrayList<Post> createPost(Post newPost){
        ArrayList<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("This is your first Post");
        post.setBody("This is your first body");
        post.setDate(new Date());

        newPost.setDate(new Date());

        posts.add(post);
        posts.add(newPost);

        return posts;

    }*/

    public void createPost(Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post"+ newPost);
    }

    public Post getPost(Integer id){
        return repository.getPost(id);
    }

    public void updatePost(Post post){
        post.setDate(new Date());
        repository.updatePost(post);
    }

    public void removePost(Integer id){
        repository.removePost(id);
    }
}
