import java.util.ArrayList;

public class Post {
    private String title;
    private String content;
    private Post replyTo;
    private User author;
    private int upvoteCount;
    private int downvoteCount;

    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.upvoteCount = 1;
        this.downvoteCount = 0;
        this.replyTo = null;
    }

    public Post(String content, Post replyTo, User author) {
        this.title = null;
        this.content = content;
        this.replyTo = replyTo;
        this.author = author;
        this.upvoteCount = 1;
        this.downvoteCount = 0;
    }

    public String getTitle() {
        return title;
    }

    public Post getReplyTo() {
        return replyTo;
    }

    public User getAuthor() {
        return author;
    }

    public int getUpvoteCount() {
        return upvoteCount;
    }

    public int getDownvoteCount() {
        return downvoteCount;
    }

    public void updateUpvoteCount(boolean isIncrement) {
        if (isIncrement) {
            upvoteCount++;
        }
        else {
            upvoteCount--;
        }
    }

    public void updateDownvoteCount(boolean isIncrement) {
        if (isIncrement) {
            downvoteCount++;
        }
        else {
            downvoteCount--;
        }
    }

    public ArrayList<Post> getThread() {
        ArrayList<Post> thread = new ArrayList<>();
        Post currentPost = this;
        while (currentPost != null) {
            thread.add(0, currentPost);
            currentPost = currentPost.getReplyTo();
        }
        return thread;
    }

    @Override
    public String toString() {
        if (title != null) {
            return String.format("[%d|%d]\t%s\n\t%s", upvoteCount, downvoteCount, title, content);
        }
        else {
            return String.format("[%d|%d]\t%s", upvoteCount, downvoteCount, content);
        }
    }
}
