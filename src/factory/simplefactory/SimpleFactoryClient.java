package factory.simplefactory;

public class SimpleFactoryClient {

    public static void main(String[] args) {

        Post news = SimpleFactory.createAPost("news");
        System.out.println(news);

        Post blog = SimpleFactory.createAPost("bloG");
        System.out.println(blog);

        Post tweet = SimpleFactory.createAPost("Tweet");
        System.out.println(tweet);

    }

}

class SimpleFactory{
    static Post createAPost(String typeOfPost){
        switch(typeOfPost.toLowerCase()) {
            case "news":
                return new NewsPost();
            case "blog":
                return new Blog();
            case "tweet":
                return new Tweet();
            default: {
                try {throw new IllegalAccessException("No such post");}
                catch (Exception e){}
            }
        }
        return null;
    }
}


interface Post{
    //some fields and methods
}

class NewsPost implements Post{

}

class Tweet implements Post{

}

class Blog implements Post{

}