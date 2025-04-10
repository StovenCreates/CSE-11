import java.util.ArrayList;

public class User {
    private int karma;
    private String username;
    private ArrayList<Post> posts;
    private ArrayList<Post> upvoted;
    private ArrayList<Post> downvoted;

    public User(String username) {
        this.username = username;
        this.karma = 0;
        this.posts = new ArrayList<>();
        this.upvoted = new ArrayList<>();
        this.downvoted = new ArrayList<>();
    }

    public void addPost(Post post) {
        if (post != null) {
            posts.add(post);
            updateKarma();
        }
    }

    public void updateKarma() {
        karma = 0;
        for (Post post : posts) {
            karma += post.getUpvoteCount() - post.getDownvoteCount();
        }
    }

    public int getKarma() {
        return karma;
    }

    public void upvote(Post post) {
        if (post == null || upvoted.contains(post) || post.getAuthor() == this) {
            return;
        }

        if (downvoted.contains(post)) {
            downvoted.remove(post);
            post.updateDownvoteCount(false);
        }

        upvoted.add(post);
        post.updateUpvoteCount(true);
        post.getAuthor().updateKarma();
    }

    public void downvote(Post post) {
        if (post == null || downvoted.contains(post) || post.getAuthor() == this) {
            return;
        }

        if (upvoted.contains(post)) {
            upvoted.remove(post);
            post.updateUpvoteCount(false);
        }

        downvoted.add(post);
        post.updateDownvoteCount(true);
        post.getAuthor().updateKarma();
    }

    public Post getTopPost() {
        Post topPost = null;
        for (Post post : posts) {
            if (post.getTitle() != null) {
                if (topPost == null || (post.getUpvoteCount() - post.getDownvoteCount()) > (topPost.getUpvoteCount() - topPost.getDownvoteCount())) {
                    topPost = post;
                }
            }
        }
        return topPost;
    }

    public Post getTopComment() {
        Post topComment = null;
        for (Post post : posts) {
            if (post.getTitle() == null) {
                if (topComment == null || (post.getUpvoteCount() - post.getDownvoteCount()) > (topComment.getUpvoteCount() - topComment.getDownvoteCount())) {
                    topComment = post;
                }
            }
        }
        return topComment;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return String.format("u/%s Karma: %d", username, karma);
    }
}
