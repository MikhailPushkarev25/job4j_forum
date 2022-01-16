package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class PostRepository {

    private final Map<Integer, Post> postMap = new HashMap<>();
    private final AtomicInteger postsIndex = new AtomicInteger(4);

    public PostRepository() {
        LocalDateTime now = LocalDateTime.now();
//        Post post1 = Post.of(
//                1,
//                "Продаю автомобиль audi A3",
//                "надоела машина, бнзин жрет 20 литров на сотку, при этом масло лью каждые 200 км.",
//               now.format(DateTimeFormatter.ISO_DATE_TIME));
//        Post post2 = Post.of(
//                2,
//                "Нашел новую работу BackAnd dewops java, зп в два раза больше предлагают",
//                "На старой работе в принципе нормально, но по деньгам не очень",
//                now.format(DateTimeFormatter.ISO_DATE_TIME));
//        Post post3 = Post.of(
//                3,
//                "Мечта пройти курс и найти работу Java-разработчиком",
//                "Остался последний блок курса и начну готовится к собеседованиям!",
//                now.format(DateTimeFormatter.ISO_DATE_TIME));
//        postMap.put(1, post1);
//        postMap.put(2, post2);
//        postMap.put(3, post3);
    }

    public Collection<Post> getAllPost() {
        return postMap.values();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(postsIndex.incrementAndGet());
        }
        postMap.put(post.getId(), post);
    }

    public Post findById(int id) {
        return postMap.get(id);
    }
}
